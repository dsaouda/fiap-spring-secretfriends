<template>
    <template-app>
        
        <div v-if="messageSuccess" class="ui success message">
            <i onclick="$(this).parent().remove()" class="close icon"></i>            
            <p>{{messageSuccess}}</p>
        </div>

        <h2>Convites</h2>
        
        <div class="ui form">
            <div class="field">
                <select v-model.lazy="filtro">
                    <option value="aguardando">Aguardando</option>
                    <option value="cancelados">Cancelados</option>
                    <option value="aprovados">Aprovados</option>
                </select>
            </div>
        </div>    

        <div class="ui modal">
            <i class="close icon"></i>
            <div class="header">
                {{grupo.nome}}
            </div>
            <div class="image content">                
                <div class="description">
                    <div class="ui header">Evento criado por {{grupo.administrador.nome}}</div>
                    <p>Valor do presente: {{grupo.valorPresente | naoInformado }}</p>
                    <p>Local: {{grupo.localEvento}}</p>
                    <p>Data Sorteio: {{grupo.dataSorteio}}</p>
                    <p>Data Evento: {{grupo.dataEvento}}</p>
                    <p>Observação: {{grupo.observacoes | naoInformado }}</p>
                    
                    <p v-if="convite.aceitoEm" class="aceitou">Você aceitou participar do grupo em {{convite.aceitoEm}}</p>
                    <p v-if="convite.canceladoEm" class="rejeitou">Você rejeitou participar do grupo em {{convite.canceladoEm}}</p>
                </div>
            </div>

            <div v-if="convite.aceitoEm === '' && convite.canceladoEm === '' && grupo.status === 'SORTEIO_NAO_REALIZADO'" class="actions">
                <div @click="rejeitar()" class="ui negative right labeled icon button">
                    Rejeitar
                    <i class="close icon"></i>
                </div>

                <div @click="participar()" class="ui positive right labeled icon button">
                    Participar
                    <i class="checkmark icon"></i>
                </div>
            </div>
        </div>

        <table class="ui table">
            <thead>
                <tr>
                    <th>Grupo</th>
                    <th>De</th>
                    <th>Recebido</th>
                    <th></th>                    
                </tr>
            </thead>
            <tbody>
                <tr v-for="(convite, index) in convites" v-if="mostrarConformeFiltro(convite)">
                    <td>{{convite.grupo}}</td>
                    <td>{{convite.de}}</td>
                    <td>{{convite.recebido}}</td>
                    <td>
                        <a href="#" title="informações do grupo" @click.prevent="informacoes(convite)">
                            <i class="newspaper icon"></i>
                        </a>                   
                    </td>
                </tr>
            </tbody>
        </table>

    </template-app>
</template>

<script>
import conviteService from '../service/conviteService.js';
import grupoService from '../service/grupoService.js';
import participanteService from '../service/participanteService.js';
import Template from './Template.vue';

export default {
    components: {
        'template-app' : Template
    },
    
    data() {
        return {
            filtro: 'aguardando',
            messageSuccess: '',
            grupo: {
                administrador: {}
            },
            convites: [],
            convite: {},
            modal: {},
        }
    },
   
    created: function () {
        conviteService.recebidos(this);
        
    },

    watch: {
        grupo: function() {}
    },

    filters: {
        naoInformado: function(value) {
            value = $.trim(value);
            if (value === '' || value === null || value === undefined) {
                return 'Não informado';
            }
            return value;
        },

    },

    destroyed: function() {
        //previnindo de abrir mais de um modal
        //todo entender por que mais de um modal estava sendo aberto
        $('.ui.modal').remove();
    },

    methods: {
        mostrarConformeFiltro: function(convite) {
            switch(this.filtro) {
                case 'aguardando':
                    return convite.canceladoEm === '' && convite.aceitoEm === '' ? true : false;

                case 'cancelados':
                    return convite.canceladoEm ? true : false; 
                    
                case 'aprovados': 
                    return convite.aceitoEm ? true : false;
                    

                default: 
                    return false; 
            }
        },

        informacoes: function(convite) {
            $('.ui.modal').modal('show');

            this.grupo = { administrador: {} };
            this.convite = convite;
            grupoService.get(this, convite.grupoUid);    
        },

        participar: function(convite) {
            participanteService.participar(this.grupo.uuid)
                .then((resp) => {
                    conviteService.recebidos(this);
                    this.messageSuccess = `Parabéns, agora você está participando do grupo ${resp.grupo.nome}`; 
                });
        },

        rejeitar: function(convite) {
            conviteService.rejeitar(this.grupo.uuid)
                .then((resp) => {
                    conviteService.recebidos(this);
                    this.messageSuccess = 'Você rejeitou a participação ao grupo'; 
                });
        }
    }
}
</script>

<style scoped>
    .rejeitou {
        color: red;    
    }

    .aceitou {
        color: green;
    }
</style>