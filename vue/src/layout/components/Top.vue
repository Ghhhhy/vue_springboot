<template>
  <div class="container">
    <h1>高考志愿推荐系统</h1>
    <a-menu
      theme="dark"
      mode="horizontal"
      v-model="current"
      :defaultSelectedKeys="current"
    >
      <a-menu-item v-for="route in routes" :key="route.path">
        <router-link :to="route.path">
          {{ route.children[0].meta.title }}
        </router-link>
      </a-menu-item>
    </a-menu>

    <div class="location">
      {{ location }} <span @click="changeLocation()">[切换]</span>
    </div>
    <a-modal
      title="选择地区"
      on-ok="handleOk"
      okText="确认"
      cancelText="取消"
      @cancel="handleCancel"
      @ok="handleOk"
      :visible="visible"
    >
      <a-form-model :label-col="{ span: 4 }" :wrapper-col="{ span: 14 }">
        <a-form-item label="地区">
          <a-select
            default-value="北京"
            style="width: 320px"
            v-model="location"
          >
            <a-select-option
              v-for="(item, index) in options"
              :key="index"
              :value="item"
            >
              {{ item }}
            </a-select-option>
          </a-select>
        </a-form-item>
      </a-form-model>
    </a-modal>

    <div class="loginContainer" v-if="!isLogin">
      <a-button type="primary">
        <router-link to="/login">登录/注册</router-link>
      </a-button>
    </div>
    <a-dropdown v-else class="settingContainer" :trigger="['click']">
      <a class="ant-dropdown-link" @click="(e) => e.preventDefault()">
        <a-avatar size="large" icon="user" />
      </a>
      <a-menu slot="overlay">
        <a-menu-item key="1">
          <router-link to="/setting" :style="{ margin: '0 0', padding: '0 0' }">
            <a-icon type="user" />个人设置
          </router-link>
        </a-menu-item>
        <a-menu-item key="2" @click="handleLoginOut()">
          <a-icon type="logout" />退出登录
        </a-menu-item>
      </a-menu>
    </a-dropdown>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "Top",
  data() {
    return {
      location: "北京",
      options: [
        "北京",
        "天津",
        "辽宁",
        "吉林",
        "黑龙江",
        "上海",
        "江苏",
        "浙江",
        "安徽",
        "福建",
        "山东",
        "湖北",
        "湖南",
        "广东",
        "重庆",
        "四川",
        "陕西",
        "甘肃",
        "河北",
        "山西",
        "内蒙古",
        "河南",
        "海南",
        "广西",
        "贵州",
        "云南",
        "西藏",
        "青海",
        "宁夏",
        "新疆",
        "江西",
        "香港",
        "澳门",
        "台湾",
      ],
      current: [],
      visible: false,
    };
  },
  computed: {
    ...mapGetters(["permission_routes", "isLogin", "province"]),
    routes() {
      return this.permission_routes.filter((item) => {
        if (item.hidden) {
          return false;
        } else {
          return true;
        }
      });
    },
  },
  mounted() {
    this.$store.dispatch("permission/generateRoutes");
    this.activeMenu();
  },
  methods: {
    changeLocation() {
      this.visible = true;
    },
    handleOk() {
      this.visible = false;
      this.$store.dispatch("user/setProvince", this.location);
    },
    handleCancel() {
      this.visible = false;
    },
    handleLoginOut() {
      this.$store.dispatch("user/loginOut");
      this.$router.push({ path: this.current[0] });
    },
    activeMenu() {
      const { path } = this.$route;
      const arr = path.split("/");
      this.current[0] = "/" + arr[1];
    },
  },
};
</script>


<style scoped>
.container {
  margin: 0;
  padding: 0;
  height: 64px;
  width: 1419.2px;
  position: relative;
}

.container h1 {
  margin: 0;
  padding: 0;
  color: white;
  position: absolute;
  height: 64px;
  text-align: center;
  line-height: 64px;
}

.container .ant-menu {
  position: absolute;
  left: 180px;
  height: 64px;
  text-align: center;
  line-height: 64px;
  font-size: 17px;
}

.location {
  color: white;
  position: absolute;
  right: 160px;
}

.location span:hover {
  color: #1890ff;
  cursor: pointer;
}

.loginContainer {
  height: 64px;
  text-align: center;
  position: absolute;
  right: 0;
}

.settingContainer {
  width: 150px;
  height: 64px;
  text-align: center;
  position: absolute;
  right: 0;
}

.ant-dropdown ul li {
  height: 50px;
  margin: 0;
  padding: 0;
  text-align: center;
  font-size: 16px;
  line-height: 50px;
}

.ant-dropdown-menu {
  padding: 0;
  border-radius: 0;
}
</style>
