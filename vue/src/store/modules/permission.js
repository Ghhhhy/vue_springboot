import { routes } from '@/router'

const state = {
  routes: []
}

const mutations = {
  SET_ROUTES: (state) => {
    state.routes = routes
  }
}

const actions = {
  generateRoutes({ commit }) {
    commit('SET_ROUTES')
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
