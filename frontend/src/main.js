import Vue from 'vue'
import App from './App.vue'

import flashMessage from './FlashMessage.js';

window.flashMessage = flashMessage;

import VueResource from 'vue-resource';
import VueRouter from 'vue-router'

import { routes } from './routes';

Vue.use(VueRouter);

const router = new VueRouter({routes : routes});

Vue.use(VueResource);

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
