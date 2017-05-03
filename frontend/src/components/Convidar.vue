<template>
    <template-app>

        <div v-if="messageSuccess" class="ui info message">
            <i class="close icon"></i>
            <div class="header">
                {{messageSuccess}}
            </div>            
        </div>

        <div v-if="messageError" class="ui error message">
            <i class="close icon"></i>
            <div class="header">
                {{messageError}}
            </div>            
        </div>

        <h2>{{grupo.nome}} que será em {{grupo.dataEvento}}</h2>

        <div class="row">
            <form class="ui form" :class="{error: errors}">

                <div class="field">
                    <label>E-mail</label>
                    <div class="ui left icon input big">
                        <i class="user icon"></i>
                        <input type="text" v-model.lazy="convite.email" placeholder="informe o e-mail do participante que deseja confirmar">
                    </div>

                    <span v-if="errors.email" class="ui error message">
                        {{ errors.email.message }}
                    </span>
                </div>

                <button v-on:click.prevent="enviar()" class="ui right labeled icon button blue big">
                    <i class="right arrow icon"></i>
                    Enviar convite
                </button>
            </form>
        </div>
        
        <div class="row">
            <br>
            <table v-if="convitesEnviados" class="ui table">
                <thead>
                    <tr>
                        <th>Para</th>
                        <th>Enviado em</th>                        
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(convite, index) in convitesEnviados">
                        <td>{{convite.para}} ({{convite.email}})</td>
                        <td>{{convite.em}}</td>                 
                    </tr>
                </tbody>
            </table>

        </div>

    </template-app>
</template>

<script>
import conviteService from '../service/conviteService.js';
import grupoService from '../service/grupoService.js';
import Template from './Template.vue';

export default {
    components: {
        'template-app' : Template
    },
    data() {
        return {
            messageSuccess: '',
            messageError: '',
            errors: {},
            convite: {},
            grupo: {},
            convitesEnviados: [],
        }
    },

    created: function() {
        this.convite.grupo = this.$route.query.uuid;
        grupoService.get(this, this.convite.grupo);
        conviteService.getEnviados(this, this.convite.grupo);
    },

    methods: {
        enviar: function() { convite.criar(this); },
        convitesEnviados: function() { convite.enviados(this); }
    }
}
</script>