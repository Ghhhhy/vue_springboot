<template>
  <div class="login-container">
    <a-card class="login-form">
      <a-form-model ref="ruleForm" :model="form" :rules="rules">
        <h2 class="login-title">注 册</h2>
        <a-form-model-item ref="username" prop="username">
          <a-input placeholder="手机号码" v-model="form.username">
            <a-icon
              slot="prefix"
              type="user"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input>
        </a-form-model-item>
        <a-form-model-item ref="password" prop="password">
          <a-input type="password" placeholder="密码" v-model="form.password">
            <a-icon
              slot="prefix"
              type="lock"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input>
        </a-form-model-item>
        <a-form-model-item ref="checkpassword" prop="checkpassword">
          <a-input
            type="password"
            placeholder="确认密码"
            v-model="form.checkpassword"
          >
            <a-icon
              slot="prefix"
              type="lock"
              style="color: rgba(0, 0, 0, 0.25)"
            />
          </a-input>
        </a-form-model-item>
        <a-form-model-item>
          <a-button type="primary" style="width: 100%" @click="handleSubmit">
            确 认
          </a-button>
        </a-form-model-item>
      </a-form-model>
    </a-card>
  </div>
</template>

<script>
import { register } from "@/api/user";

export default {
  data() {
    return {
      form: {
        username: "",
        password: "",
        checkpassword: "",
      },
      rules: {
        username: [
          { required: true, message: "请输入手机号码", trigger: "blur" },
          {
            pattern: "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$",
            message: "请输入正确的手机号",
            trigger: "blur",
          },
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        checkpassword: [
          { required: true, message: "请再输入密码", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    handleSubmit() {
      // register(this.form).then(res => {
      //   console.log(res)
      // })
      this.$refs.ruleForm.validate((valid) => {
        if (this.form.password !== this.form.checkpassword) {
          this.$message.error("两次密码不一致，请重新输入");
          return;
        }
        if (valid) {
          setTimeout(
            register({
              username: this.form.username,
              password: this.form.password,
            }).then((res) => {
              console.log(res.data.message);
              this.$message.success("注册成功");
            }),
            2000
          );
          this.$router.push({ path: "/login" });
        } else {
          console.log("注册失败");
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
.login-container {
  position: absolute;
  width: 100%;
  height: 100%;
}

.login-form {
  width: 450px;
  margin: 160px auto;
  padding: 30px;
  border: 1px solid #d9d9d9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
}

.login-title {
  color: #303133;
  text-align: center;
}
</style>
