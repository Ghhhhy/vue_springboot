const getters = {
  // token: state => state.user.token,
  name: state => state.user.name,
  isLogin: state => state.user.isLogin,
  province: state => state.user.province,
  permission_routes: state => state.permission.routes,
}

export default getters
