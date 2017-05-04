<template>
  <div>
    <div class="ui fixed inverted menu">
      <div class="ui container">
        <a href="#" class="header item">
          <i class="users icon"></i> Amigo Secreto
        </a>
        <router-link to="convites" class="item">Convites</router-link>
        <div class="ui simple dropdown item">
          Grupos <i class="dropdown icon"></i>
          <div class="menu">
            <router-link to="grupos" class="item">Administrando</router-link>
            <a class="item">Participando</a>
          </div>
        </div>
        
        <a href="#" @click.prevent="sair()" class="item">Sair</a>
      </div>
    </div>

    <div class="ui main text container">
      <br><br><br>
      <slot></slot>
    </div>
  </div>
</template>

<script>

export default {
    methods: {
        sair: function() {
            console.log('sair');
        }
    }  
}
</script>