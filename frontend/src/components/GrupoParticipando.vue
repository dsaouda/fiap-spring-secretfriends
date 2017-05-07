<template>
    <template-app>
        <h2>Grupos Participando</h2>

        <p>obs: todo grupo que você administra, automaticamente você é um participante.</p>
        

        <div class="ui form">
            <div class="field">
                <select v-model.lazy="filtro">
                    <option value="TODOS">Todos</option>
                    <option value="SORTEIO_NAO_REALIZADO">Sorteio não realizado</option>
                    <option value="SORTEIO_REALIZADO">Sorteio realizado</option>
                    <option value="EVENTO_VAI_OCORRER">Evento que vai ocorrer</option>
                    <option value="EVENTO_OCORREU">Evento que já ocorreu</option>
                </select>
            </div>
        </div>

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
            <tr v-for="(participando, index) in participacoes" v-if="mostrarConformeFiltro(participando)">
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
            filtro: 'TODOS',
            participacoes: [],
            message: ''
        }
    },
   
    created: function () {
        participanteService.getParticipacoes().then(r => this.participacoes = r.data);
    },
    methods: {
        mostrarConformeFiltro: function(participando) {
            switch(this.filtro) {
                case 'TODOS':
                    return true;

                case 'SORTEIO_NAO_REALIZADO':
                    return participando.amigoSecreto === null;
                    
                case 'SORTEIO_REALIZADO': 
                    return participando.amigoSecreto !== null;

                case 'EVENTO_VAI_OCORRER': 
                    return participando.grupo.eventoOcorreu === false ? true : false;

                case 'EVENTO_OCORREU': 
                    return participando.grupo.eventoOcorreu === true ? true : false;
            }
        },
    }
}
</script>

<style scoped>
    .error {
        color: red;
    }
</style>