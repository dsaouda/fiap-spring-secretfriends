<template>
  <div>

    <div class="ui fixed inverted menu">
      <div class="ui container">
        <a href="#" class="header item">
          <i class="users icon"></i> Amigo Secreto

        </a>
        <router-link class="item" to="/">Home</router-link>
        <a href="#" class="item">Sobre</a>

      </div>
    </div>

    <div class="ui main text container">
      <h2>Cadastro</h2>

      <div class="row">
        Informe apenas mais alguns dados para começar a brincar
      </div>

      <div class="row">&nbsp;</div>

      <div v-if="message" class="ui error message">
        <i class="warning sign icon"></i> {{message}}
      </div>



      <div class="row">
        <form class="ui form" :class="{error: errors}">

          <div class="field">
            <label>Nome</label>
            <div class="ui left icon input big">
              <i class="user icon"></i>
              <input type="text" v-model.lazy="usuario.nome" name="nome" placeholder="informe seu nome">
            </div>

            <span v-if="errors.nome" class="ui error message">
              {{ errors.nome.message }}
            </span>

          </div>

          <div class="field">
            <label>E-mail</label>
            <div class="ui left icon input big">
              <i class="at icon"></i>
              <input type="email" v-model.lazy="usuario.email" name="email" placeholder="informe seu e-mail">
            </div>

            <span v-if="errors.email" class="ui error message">
              {{ errors.email.message }}
            </span>
          </div>

          <div class="field">
            <label>Senha</label>

            <div class="ui right labeled left icon input big">
              <i class="lock icon"></i>

              <input v-if="typePassword === 'text'" type="text" v-model.lazy="usuario.senha" name="senha" placeholder="informe sua senha">
              <input v-if="typePassword !== 'text'" type="password" v-model.lazy="usuario.senha" name="senha" placeholder="informe sua senha">

              <span v-on:mouseup="hidePassword" v-on:mousedown="showPassword" class="ui label"><i :class="iconPassword"></i></span>
            </div>

            <span v-if="errors.plainSenha" class="ui error message">
              {{ errors.plainSenha.message }}
            </span>
          </div>

          <button v-on:click="cadastrar($event)" class="ui right labeled icon button blue big">
              <i class="right arrow icon"></i>
              Cadastrar
            </button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import {rcpOpen as $http} from '../service/http.js';

export default {
  data() {
    return {
      message: null,
      errors: {},

      usuario: {
        senha: '',
        nome: '',
        email: ''
      },

      typePassword: 'password',
      iconPassword: 'hide icon'
    }
  },
  methods: {
    
    cadastrar: function(event) {
      event.preventDefault();

      this.errors = {};
      this.message = '';

      $http.post('/login/cadastro', this.usuario)
        .then(response => {
          flashMessage.set('message', 'Usuário criado com sucesso');
          this.$router.push('/');
      }).catch(e => {
        let error = e.response.data;
        
        if (error.data) {
          this.errors = error.data;
        }

        if (error.message) {
          this.message = error.message;
        }
      });
    },

    showPassword: function () {
      this.typePassword = 'text';
      this.iconPassword = 'unhide icon';
    },

    hidePassword: function() {
      this.typePassword = 'password';
      this.iconPassword = 'hide icon';
    }

  }

}
</script>

<style scoped>
  .ui.main.text.container {
    margin-top: 50px;
  }
</style>