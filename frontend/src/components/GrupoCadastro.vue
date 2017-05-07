<template>
    <template-app>
        
        <h2>Novo Grupo</h2>

        <div class="row">
            <form class="ui form" :class="{error: errors}" @submit.prevent="salvar">

                <div class="field">
                    <label>Nome *</label>
                    <div class="ui left icon input big">
                        <i class="user icon"></i>
                        <input type="text" required v-model.lazy="grupo.nome" placeholder="nome do grupo">
                    </div>

                    <span v-if="errors.nome" class="ui error message">
                        {{ errors.nome.message }}
                    </span>

                </div>

                <div class="field">
                    <label>Valor presente</label>
                    <div class="ui left icon input big">
                        <i class="money icon"></i>
                        <input type="number" v-model.lazy="grupo.valorPresente" placeholder="valor presente">
                    </div>

                    <span v-if="errors.valoPresente" class="ui error message">
                        {{ errors.valorPresente.message }}
                    </span>

                </div>

                <div class="field">
                    <label>Data/hora do evento *</label>
                    <div class="ui left icon input big">
                        <i class="calendar icon"></i>
                        <input type="text" v-model.lazy="grupo.dataEvento" required pattern="[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}:[0-9]{2}" placeholder="dd/MM/yyyy HH:mm">
                    </div>
                    
                    <span v-if="errors.dataEventoMaiorQueDataSorteio" class="ui error message">
                        {{ errors.dataEventoMaiorQueDataSorteio.message }}
                    </span>

                    <span v-if="errors.dataEvento" class="ui error message">
                        {{ errors.dataEvento.message }}
                    </span>
                </div>

                <div class="field">
                    <label>Data/hora do sorteio *</label>
                    <div class="ui left icon input big">
                        <i class="calendar icon"></i>
                        <input type="text" v-model.lazy="grupo.dataSorteio" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4} [0-9]{2}:[0-9]{2}" placeholder="dd/MM/yyyy HH:mm">
                    </div>

                    <span v-if="errors.dataSorteio" class="ui error message">
                        {{ errors.dataSorteio.message }}
                    </span>
                </div>

                <div class="field">
                    <label>Local evento *</label>
                    <div class="ui left icon input big">
                        <i class="marker icon"></i>
                        <input type="text" required v-model.lazy="grupo.localEvento" placeholder="local evento">
                    </div>

                    <span v-if="errors.localEvento" class="ui error message">
                        {{ errors.localEvento.message }}
                    </span>
                </div>

                <div class="field">
                    <label>Observações</label>
                    <div class="ui left icon input big">
                        <i class="content icon"></i>
                        <input type="text" v-model.lazy="grupo.observacoes" placeholder="observações">
                    </div>

                    <span v-if="errors.observacoes" class="ui error message">
                        {{ errors.observacoes.message }}
                    </span>
                </div>

                <button class="ui right labeled icon button blue big">
                    <i class="right arrow icon"></i>
                    Salvar
                </button>
            </form>
        </div>

    </template-app>
</template>

<script>
import grupoService from '../service/grupoService';
import Template from './Template.vue';

export default {
    components: {
        'template-app' : Template
    },
    
    data() {
        return {
            message: '',
            errors: {},
            grupo: {},
        }
    },

    methods: {
        salvar: function() {
            this.errors = {};
            this.message = '';
            
            grupoService.criar(this.grupo)
                .then(response => {
                    flashMessage.set('message', 'Grupo cadastrado com sucesso');
                    this.$router.push('/grupos');
                }).catch(e => {
                    let error = e.data;

                    if (error) {
                        this.errors = error;
                    }

                    if (e.message) {
                        this.message = e.message;
                    }
                });
        },
    }
}
</script>