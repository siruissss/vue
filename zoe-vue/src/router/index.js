import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import Appindex from '../components/home/Appindex'
import Login from "../components/Login";

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name:'Appindex',
      component: Appindex
    }
  ]
})
