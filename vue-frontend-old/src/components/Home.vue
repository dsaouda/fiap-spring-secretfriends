<template>
  <div class="ui middle aligned center aligned grid ds-layout-center">
    <div class="column">
      <h2 class="ui teal image header">
        <div class="content">
          Crie seu grupo e convide o pessoal
        </div>
      </h2>
      <form class="ui large form">
        <div class="ui stacked segment">
          <div class="field">
            <div class="ui left icon input">
              <i class="user icon"></i>
              <input type="text" name="email" placeholder="E-mail">
            </div>
          </div>
          <div class="field">
            <div class="ui left icon input">
              <i class="lock icon"></i>
              <input type="password" name="password" placeholder="Senha">
            </div>
          </div>
          <div class="ui fluid large teal submit button">Login</div>
        </div>

        <div class="ui error message"></div>

      </form>

      <div class="ui message">
        Ainda não se cadastrou? <a href="#">Cadastre-se aqui</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style>
  body {
    background: url(https://image.shutterstock.com/z/stock-photo-group-of-friends-enjoying-party-and-throwing-confetti-friends-having-fun-at-rooftop-party-565003417.jpg)
  }
</style>

<style scoped>
  
  .ds-layout-center {
    margin: 0 auto;
    width: 400px;
  }
</style>
