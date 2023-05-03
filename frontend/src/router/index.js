import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ToolView from '../views/ToolView.vue'
import MyPageWork from '../views/MypageViewWork.vue'
import MyPagePoint from '../views/MypageViewPoint.vue'
import MyPageChargeResult from '../views/MypageViewChargeResult.vue'
import ToolSubmitView from '../views/ToolSubmitView.vue'
import SearchView from "../views/SearchView.vue";
import BookDetailView from "../views/BookDetailView.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/tool',
    name: 'tool',
    component: ToolView
  },
  {
    path: "/toolSubmit",
    name: "ToolSubmit",
    component: ToolSubmitView
  },
  {
    path: '/mypage/workmanage',
    name: 'MyPageWork',
    component: MyPageWork
  },
  {
    path: '/mypage/pointmanage',
    name: 'MyPagePoint',
    component: MyPagePoint
  },
  {
    path: '/mypage/chargeResult',
    name: 'MyPageChargeResult',
    component: MyPageChargeResult
  },
  {
    path: '/search',
    name: 'Search',
    component: SearchView
  },
  {
    path: '/detail/:id',
    name: 'BookDetail',
    component: BookDetailView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
