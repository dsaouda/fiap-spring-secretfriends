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

                <button v-on:click.prevent="salvar()" class="ui right labeled icon button blue big">
                    <i class="right arrow icon"></i>
                    Enviar convite
                </button>
            </form>
        </div>

    </template-app>
</template>

<script>
import {rpc as $httpRpc} from '../service/http.js';
import {rest as $httpRest} from '../service/http.js';
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

        }
    },

    created: function() {
        this.convite.grupo = this.$route.query.uuid;
        
        $httpRest.get('/grupo/' + this.convite.grupo)
            .then(r => {                    
                this.grupo = r.data.data;

            }).catch(e => {
                
            });

    },

    methods: {
        salvar: function() {            
            this.messageSuccess = '';
            this.messageError = '';

            $httpRpc.post('/convite/enviar', this.convite)
            .then(r => {
                this.messageSuccess = 'Convite enviado com sucesso!';
                this.grupo.email = '';
                
            }).catch(e => {
                console.log(e.response.data.message);
                this.messageError = e.response.data.message;
            });
        }
    }
}
</script>

<style scoped>

</style>