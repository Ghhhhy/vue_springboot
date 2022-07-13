<template>
  <!-- <div class="login-container">
    <a-card class="login-form">
      <h2 class="login-title">登 录</h2>
      <a-form-model :model="loginForm">
        <a-form-model-item>
          <a-input placeholder="账号" v-model="loginForm.username">
            <a-icon
              slot="prefix"
              type="user"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input>
        </a-form-model-item>
        <a-form-model-item>
          <a-input type="password" placeholder="密码" v-model="loginForm.password">
            <a-icon
              slot="prefix"
              type="lock"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input>
        </a-form-model-item>
        <a-form-model-item>
          <a-button type="primary" @click="handleLogin" class="login-button">
            登 录
          </a-button>
          <a-button type="link" @click="handleRegister" class="register-button">
            注 册
          </a-button>
        </a-form-model-item>
      </a-form-model>
    </a-card>
  </div> -->
  <div class="login-container">
    <div class="left-container">
      <p style="margin-top: 40px">高考志愿推荐系统</p>
      <img src="@/assets/日历日程.png" style="width: 250px; height: 250px" />
    </div>
    <div class="right-container">
      <p class="title">登 录</p>
      <a-form-model :model="loginForm" class="form">
        <a-form-model-item>
          <a-input placeholder="账号" v-model="loginForm.username">
            <a-icon
              slot="prefix"
              type="user"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input>
        </a-form-model-item>
        <a-form-model-item>
          <a-input
            type="password"
            placeholder="密码"
            v-model="loginForm.password"
          >
            <a-icon
              slot="prefix"
              type="lock"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input>
        </a-form-model-item>
        <a-form-model-item>
          <a-button type="primary" @click="handleLogin" class="login-button" style="width: 100%">
            登 录
          </a-button>
          <a-button type="link" @click="handleRegister" class="register-button">
            注 册
          </a-button>
        </a-form-model-item>
      </a-form-model>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loginForm: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    handleLogin() {
      this.$store
        .dispatch("user/login", this.loginForm)
        .then(() => {
          this.$message.success("登录成功");
          this.$router.push({ path: "/" });
        })
        .catch((err) => {
          this.$message.error(err);
        });
      // console.log(this.loginForm);
    },
    handleRegister() {
      this.$router.push("/register");
    },
  },
};
</script>

<style scoped>
.login-container {
  position: absolute;
  width: 750px;
  height: 400px;
  left: 50%;
  top: 50%;
  transform: translateX(-50%) translateY(-50%);
  border: 1px solid #d9d9d9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
  display: flex;
}

.left-container {
  width: 300px;
  height: 100%;
  background-color: #1890ff;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  color: white;
  font-size: 20px;
  font-weight: bold;
}

.right-container {
  width: 450px;
  height: 100%;
  position: relative;
  color: #1890ff;
  font-size: 20px;
  font-weight: bold;
}

.right-container .title {
  position: absolute;
  left: 45%;
  top: 40px;
  letter-spacing: 14px;
}

.right-container .form {
  width: 80%;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  margin-top: 120px;
}

/* .login-container {
  position: absolute;
  width: 100%;
  height: 100%;
}

.login-form {
  width: 450px;
  margin: 160px auto;
  padding: 30px;
}

.login-title {
  color: #303133;
  text-align: center;
}

.login-button {
  position: absolute;
  width: 200px;
  height: 40px;
  font-size: 15px;
}

.register-button {
  position: absolute;
  top: 5px;
  left: 250px;
} */
</style>
