import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/layout/index'

Vue.use(VueRouter)

export const routes = [
  {
    path: '/',
    component: Layout,
    redirect: '/home',
    children: [{
      path: 'home',
      component: () => import('@/views/home'),
      name: 'Home',
      meta: { title: '首页' }
    }]
  },
  {
    path: '/school',
    component: Layout,
    redirect: '/school/index',
    children: [{
      path: 'index',
      component: () => import('@/views/school/'),
      name: 'School',
      meta: { title: '找大学' }
    }]
  },
  {
    path: '/school-info',
    component: Layout,
    redirect: '/shool-info/index',
    hidden: true,
    children: [{
      path: 'index',
      component: () => import('@/views/school-info'),
      name: 'School-info',
      meta: { title: '学校详情' }
    }]
  },
  {
    path: '/profession',
    component: Layout,
    redirect: '/profession/index',
    children: [{
      path: 'index',
      component: () => import('@/views/profession'),
      name: 'Profession',
      meta: { title: '查专业' }
    }]
  },
  {
    path: '/profession-info',
    component: Layout,
    redirect: '/profession-info/index',
    hidden: true,
    children: [{
      path: 'index',
      component: () => import('@/views/profession-info'),
      name: 'Profession-info',
      meta: { title: '专业详情' }
    }]
  },
  {
    path: '/new-info',
    component: Layout,
    redirect: '/new-info/index',
    hidden: true,
    children: [{
      path: 'index',
      component: () => import('@/views/new-info'),
      name: 'Profession-info',
      meta: { title: '新闻详情' }
    }]
  },
  {
    path: '/selector',
    component: Layout,
    redirect: '/selector/index',
    children: [{
      path: 'index',
      component: () => import('@/views/selector'),
      name: 'Selector',
      meta: { title: '智能选大学' }
    }]
  },
  {
    path: '/setting',
    component: Layout,
    redirect: '/setting/index',
    hidden: true,
    children: [{
      path: 'index',
      component: () => import('@/views/setting'),
      name: 'Setting',
      meta: { title: '设置' }
    }]
  },
  {
    path: '/consult',
    component: Layout,
    redirect: '/consult/index',
    hidden: true,
    children: [{
      path: 'index',
      component: () => import("@/views/consult"),
      name: 'consult',
      meta: { title: '咨询' }
    }]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    name: 'login',
    hidden: true
  },
  {
    path: '/register',
    component: () => import('@/views/register/index'),
    name: 'register',
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },
  {
    path: '*',
    redirect: '404',
    hidden: true
  }
]

const createRouter = () => new VueRouter({
  mode: 'history',
  scrollBehavior: () => ({ y: 0 }),
  routes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher
}

export default router
