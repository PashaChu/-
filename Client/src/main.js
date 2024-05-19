import { createApp } from 'vue';
import { createRouter, createWebHistory } from 'vue-router';
import './style.css';
import App from './App.vue';
import Autorize from './Autorize.vue';
import Registration from './Registration.vue';
import Client from './components/administrator/Client.vue';
import Coach from './components/administrator/Coach.vue';
import Hall from './components/administrator/Hall.vue';
import Training from './components/administrator/Training.vue';
import Record from './components/administrator/Record.vue';
import TableMenu from './components/administrator/TableMenu.vue';
import TableUserMenu from './components/user/TableUserMenu.vue';
import Coaches from './components/user/Coaches.vue';
import Halls from './components/user/Halls.vue';
import Records from './components/user/Records.vue';
import Trainings from './components/user/Trainings.vue';

const routes = [
  { path: '/autorize', name: 'autorize-form', component: Autorize },
  { path: '/registration', name: 'registration-form', component: Registration },
  { path: '/menu-admin', name: 'table-menu', component: TableMenu },
  { path: '/menu-user', name: 'table-user', component: TableUserMenu },
  { path: '/coachUser', name: 'coach', component: Coaches },
  { path: '/hallUser', name: 'hall', component: Halls },
  { path: '/recordUser', name: 'record', component: Records },
  { path: '/trainingUser', name: 'training', component: Trainings },
  { path: '/users', name: 'userTable', component: Client },
  { path: '/coaches', name: 'coachTable', component: Coach },
  { path: '/halls', name: 'hallTable', component: Hall },
  { path: '/trainings', name: 'trainingTable', component: Training },
  { path: '/records', name: 'recordTable', component: Record },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

const app = createApp(App);
app.use(router);
app.component('table-menu', TableMenu);
app.mount('#app');

