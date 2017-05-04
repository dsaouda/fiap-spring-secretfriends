<template>
    <template-app>
        
        <div v-if="messageSuccess" class="ui success message">
            <i @click="fecharMessageSuccess()" class="close icon"></i>            
            <p>{{messageSuccess}}</p>
        </div>

        <h2>Convites recebidos</h2>
        
        <div class="ui modal">
            <i class="close icon"></i>
            <div class="header">
                {{grupo.nome}}
            </div>
            <div class="image content">                
                <div class="description">
                    <div class="ui header">Evento criado por {{grupo.administrador.nome}}</div>
                    <p>Valor do presente: {{grupo.valorPresente}}</p>
                    <p>Local: {{grupo.localEvento}}</p>
                    <p>Data Sorteio: {{grupo.dataSorteio}}</p>
                    <p>Data Evento: {{grupo.dataEvento}}</p>
                    <p>Observação: {{grupo.observacoes}}</p>
                </div>
            </div>

            <div class="actions">
                <div @click="fechar()" class="ui black deny button">
                    Fechar
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
                    <th>De</th>
                    <th>Recebido</th>
                    <th></th>                    
                </tr>
            </thead>
        <tbody>
            <tr v-for="(convite, index) in convites">
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
            messageSuccess: '',
            grupo: {
                administrador: {}
            },
            convites: [],
        }
    },
   
    created: function () {        
        conviteService.recebidos(this);
    },

    watch: {
        grupo: function() {}
    },

    methods: {
        informacoes: function(convite) {
            this.grupo = { administrador: {} };
            grupoService.get(this, convite.grupoUid);
            $('.ui.modal').modal('show');
        },

        participar: function(convite) {
            participanteService.participar(this.grupo.uuid).then((resp) => { this.messageSuccess = `Parabéns, agora você está participando do grupo ${resp.grupo.nome}` });
            
        },

        fecharMessageSuccess: function() {
            $('.ui.success.message').hide();
        },

        fechar: function() {
           $('.ui.modal').modal('hide'); 
        }
    }
}
</script>