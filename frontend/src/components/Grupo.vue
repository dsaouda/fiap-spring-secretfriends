<template>
    <template-app>
        
        {{message}}

        <router-link to="grupo/cadastro" class="ui labeled icon button">
            <i class="file icon"></i>
            Novo grupo
        </router-link>

        <table class="ui table">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Data Sorteio</th>
                    <th>Data Evento</th>
                    <th>Valor</th>
                    <th>Local</th>
                    <th>Observações</th>
                    <th></th>
                </tr>
            </thead>
        <tbody>
            <tr v-for="(grupo, index) in grupos">
                <td>{{grupo.nome}}</td>
                <td>{{grupo.dataSorteio}}</td>
                <td>{{grupo.dataEvento}}</td>
                <td>{{grupo.valor}}</td>
                <td>{{grupo.localEvento}}</td>
                <td>{{grupo.observacoes}}</td>
                <td>
                    <router-link title="convidar" :to="querystring(grupo)">
                        <i class="announcement icon"></i>
                    </router-link>
                </td>
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