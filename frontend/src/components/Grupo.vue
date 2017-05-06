<template>
    <template-app>
        
        <h2>Grupo administrando</h2>

        <div v-if="message" class="ui success message">
            <i onclick="$(this).parent().remove()" class="close icon"></i>            
            <p>{{message}}</p>
        </div>
        
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
            <tr v-for="(grupo, index) in grupos">
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