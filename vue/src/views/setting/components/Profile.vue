<template>
  <div>
    <a-row>
      <a-col :span="15">
        <a-form-model :model="form">
          <a-form-model-item label="昵称">
            <a-input :placeholder="name" v-model="form.name" disabled />
          </a-form-model-item>
          <a-form-item label="手机号" disabled>
            <a-input :placeholder="name" v-model="form.phone" disabled></a-input>
          </a-form-item>
          <a-form-item label="新密码">
            <a-input :placeholder="name" v-model="form.password"></a-input>
          </a-form-item>
          <a-form-model-item>
            <a-button type="primary">更新基本信息</a-button>
          </a-form-model-item>
        </a-form-model>
      </a-col>
      <a-col :span="9">
        <a-avatar :size="150" icon="user" style="margin: 90px 180px" />
      </a-col>
    </a-row>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: 'Profile',
  data() {
    return {
      form: {
        name: "",
      },
    };
  },
  computed: {
    ...mapGetters(["name"]),
  },
};
</script>

<style scoped>
</style>
