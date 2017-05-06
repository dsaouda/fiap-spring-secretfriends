<template>
    <template-app>
        <h2>Grupos Participando</h2>

        obs: todo grupo que você administra, automaticamente você é um participante.

        <table class="ui table">
            <thead>
                <tr>
                    <th>Grupo</th>
                    <th>Data Sorteio</th>
                    <th>Data Evento</th>
                    <th>Valor</th>
                    <th>Local</th>
                    <th>Observações</th>
                    <th>Amigo Secreto</th>
                </tr>
            </thead>
        <tbody>
            <tr v-for="(participando, index) in participacoes">
                <td>{{participando.grupo.nome}}</td>
                <td>{{participando.grupo.dataSorteio}}</td>
                <td>{{participando.grupo.dataEvento}}</td>
                <td>{{participando.grupo.valorPresente}}</td>
                <td>{{participando.grupo.localEvento}}</td>
                <td>{{participando.grupo.observacoes}}</td>
                <td>
                    <span v-if="participando.amigoSecreto">
                        {{participando.amigoSecreto.nome}} ({{participando.amigoSecreto.email}})
                    </span>

                    <span v-else class="error">Ainda não sorteado</span>
                </td>
            </tr>
        </tbody>
        </table>

    </template-app>
</template>

<script>
import participanteService from '../service/participanteService';
import Template from './Template.vue';

export default {
    components: {
        'template-app' : Template
    },
    data() {
        return {
            participacoes: [],
            message: ''
        }
    },
   
    created: function () {
        participanteService.getParticipacoes().then(r => this.participacoes = r.data);
    },
    methods: {
        
    }
}
</script>

<style scoped>
    .error {
        color: red;
    }
</style>