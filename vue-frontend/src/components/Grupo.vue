<template>
    <template-app>
        
        <h2>Grupo administrando</h2>

        <div v-if="message" class="ui success message">
            <i onclick="$(this).parent().remove()" class="close icon"></i>            
            <p>{{message}}</p>
        </div>
        
        <div class="ui form">
            <div class="field">
                <select v-model.lazy="filtro">
                    <option value="TODOS">Todos</option>
                    <option value="SORTEIO_NAO_REALIZADO">Sorteio não realizado</option>
                    <option value="SORTEIO_SUCESSO">Sorteio realizado</option>
                    <option value="SORTEIO_FALHA">Sorteio falhou</option>
                    <option value="EVENTO_VAI_OCORRER">Evento que vai ocorrer</option>
                    <option value="EVENTO_OCORREU">Evento que já ocorreu</option>
                </select>
            </div>
        </div>
        
        <br>

        <router-link to="grupo/cadastro" class="ui labeled icon button">
            <i class="file icon"></i>
            Novo grupo
        </router-link>

        <table class="ui table">
            <thead>
                <tr>
                    <th></th>
                    <th>Nome</th>
                    <th>Data Sorteio</th>
                    <th>Data Evento</th>
                    <th>Valor</th>
                    <th>Local</th>
                    <th>Observações</th>
                    <th>Status</th>
                </tr>
            </thead>
        <tbody>
            <tr v-for="(grupo, index) in grupos" v-if="mostrarConformeFiltro(grupo)">
                <td>
                    <router-link title="convidar" :to="querystring(grupo)">
                        <i class="announcement icon"></i>
                    </router-link>
                </td>
                <td>{{grupo.nome}}</td>
                <td>{{grupo.dataSorteio}}</td>
                <td>{{grupo.dataEvento}}</td>
                <td>{{grupo.valor | empty}}</td>
                <td>{{grupo.localEvento}}</td>
                <td>{{grupo.observacoes | empty}}</td>
                <td v-html="$options.filters.status(grupo.status)"></td>
            </tr>
        </tbody>
        </table>

    </template-app>
</template>

<script>
import grupoService from '../service/grupoService.js';
import Template from './Template.vue';

export default {
    components: {
        'template-app' : Template
    },
    data() {
        return {
            filtro: 'TODOS',
            grupos: [],
            message: ''
        }
    },

    filters: {
        empty: function(value) {
            if (!value) return '-';
            return value;
        },

        status: function(value) {
            if (value === 'SORTEIO_SUCESSO') {
                return '<span class="sucesso">sorteio realizado</span>';
            }

            if (value === 'SORTEIO_FALHA') {
                return '<span class="falha" title="sorteio realizado com falha, provavelmente ninguém estava participando do grupo">falha [?]</span>';
            }

            if (value === 'SORTEIO_NAO_REALIZADO') {
                return '<span class="alerta">sorteio não realizado</span>';
            }

        }
    },
   
    created: function () {
        this.message = flashMessage.get('message');
        grupoService.getAll(this);
    },
    methods: {

        mostrarConformeFiltro: function(grupo) {
            switch(this.filtro) {
                case 'TODOS':
                    return true;

                case 'SORTEIO_NAO_REALIZADO':
                    return grupo.status === this.filtro;
                    
                case 'SORTEIO_SUCESSO': 
                    return grupo.status === this.filtro;

                case 'SORTEIO_FALHA': 
                    return grupo.status === this.filtro;

                case 'EVENTO_VAI_OCORRER': 
                    return grupo.eventoOcorreu == false ? true : false;

                case 'EVENTO_OCORREU': 
                    return grupo.eventoOcorreu == true ? true : false;

                default: 
                    return false; 
            }
        },

        querystring: function(grupo) {
            return 'convidar?uuid=' + grupo.uuid
        }
    }
}
</script>

<style>
    .sucesso {
        color: green;
    }

    .falha {
        color: red;
    }

    .alerta {
        color: orange;
    }
</style>