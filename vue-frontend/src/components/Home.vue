<template>
  <div class="ds-background">
    <div v-if="message" class="ui message">
      <div class="header">
        {{message}}
      </div>
    </div>
    

    <div class="ui middle aligned center aligned grid ds-layout-center">
      <div class="column">
        <h2 class="ui image header blue">
          <div class="content">
            Crie seu grupo e convide o pessoal
          </div>
        </h2>
        <form class="ui large form">
          <div class="ui stacked segment">
            <div class="field">
              <div class="ui left icon input huge">
                <i class="user icon"></i>
                <input v-model.lazy="login.email" type="text" name="email" placeholder="E-mail">
              </div>
            </div>
            <div class="field">
              <div class="ui left icon input huge">
                <i class="lock icon"></i>
                <input v-model.lazy="login.senha" type="password" name="password" placeholder="Senha">
              </div>
            </div>
            <button v-on:click.prevent="logar()" class="ui fluid large blue submit button huge">Login</button>
          </div>

          <div class="ui error message"></div>

        </form>

        <div class="ui message">
          Ainda não se cadastrou?
          <router-link :to="{ name: 'cadastro' }">Cadastre-se aqui</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import loginService from '../service/loginService.js';

export default {
  data() {
    return {
      message: '',
      login: { email: '', senha: '' }
    }
  },

  methods: {    
    logar: function() { loginService.logar(this); },
  },

  created: function () {      
      this.message = flashMessage.get('message');
  }
}
</script>

<style scoped>
  
  h2 * {
    padding: 10px; 
    background-color: #fff;
  }

  .ds-background {
    width: 100%;
    height: 100%;
    background: url(https://previews.123rf.com/images/michaeljung/michaeljung1408/michaeljung140800261/30685433-underneath-view-of-group-of-friends-in-a-circle-looking-down-in-autumn-forest-Stock-Photo.jpg);
    background-repeat: no-repeat;
    background-size: 100%;
  }
  
  .ds-layout-center {
    margin: 0 auto;
    width: 400px;
  }
</style>