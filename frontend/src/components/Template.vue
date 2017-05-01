<template>
  <div>
    <div class="ui fixed inverted menu">
      <div class="ui container">
        <a href="#" class="header item">
          <i class="users icon"></i> Amigo Secreto
        </a>
        <a href="#" class="item">Convites</a>
        <div class="ui simple dropdown item">
          Grupos <i class="dropdown icon"></i>
          <div class="menu">
            <a class="item" href="#">Administrando</a>
            <a class="item" href="#">Participando</a>
          </div>
        </div>
        
        <a href="#" class="item">Sair</a>
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
}
</script>