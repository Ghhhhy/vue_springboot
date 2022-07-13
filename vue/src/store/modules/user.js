import { login } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'

const state = {
  token: getToken(),
  name: '',
  isLogin: false,
  province: '北京'
  // avatar: '',
  // introduction: ''
}

const mutations = {
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_ISLOGIN: (state, isLogin) => {
    state.isLogin = isLogin
  },
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_PROVINCE:(state, province) => {
    state.province = province
  }
  // SET_AVATAR: (state, avatar) => {
  //   state.avatar = avatar
  // },
  // SET_INTRODUCTION: (state, introduction) => {
  //   state.introduction = introduction
  // }
}

const actions = {
  login({ commit }, userInfo) {
    const { username, password } = userInfo
    return new Promise((resolve, reject) => {
      login({ username: username.trim(), password: password }).then(response => {
        const { data } = response
        commit('SET_TOKEN', data.token)
        setToken(data.token)
        commit('SET_NAME', username.trim())
        commit('SET_ISLOGIN', true)
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // getInfo({ commit, state }) {
  //   getInfo(state.token).then(response => {
  //     const { data } = response
  //     const { name } = data

  //     commit('SET_NAME', name)
  //     resolve(data)
  //   }).catch(error => {
  //     reject(error)
  //   })
  // }

  loginOut({ commit }) {
    commit('SET_NAME', '')
    commit('SET_ISLOGIN', false)
    removeToken()
    resetRouter()
  },

  setProvince({ commit }, province) {
    commit('SET_PROVINCE', province)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
