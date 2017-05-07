<template>
  <div>
    <div class="ui fixed inverted menu">
      <div class="ui container">
        <a href="#" class="header item">
          <i class="users icon"></i> Amigo Secreto
        </a>
        
        <a href="https://github.com/dsaouda/fiap-spring-secretfriends" target="_blank" class="item">Sobre</a>
        <router-link :to="{name: 'convites'}" class="item">Convites</router-link>
        <div class="ui simple dropdown item">
          Grupos <i class="dropdown icon"></i>
          <div class="menu">
            <router-link :to="{name: 'grupos'}" class="item">Administrando</router-link>
            <router-link :to="{name: 'grupos_participando'}" class="item">Participando</router-link>
          </div>
        </div>
        
        <a href="#" @click.prevent="sair()" class="item">Sair</a>
      </div>
    </div>

    <div class="ui main text container">
      <br><br>
      <slot></slot>
    </div>
  </div>
</template>

<script>
import { rpcOpen as $http } from '../service/http';
export default {
    methods: {
        sair: function() {
            $http.post('/login/logout').then(() => {
                this.$router.push('/');
            });
        }
    }  
}
</script>