<template>
  <div>
    <a-result
      status="404"
      title="404"
      sub-title="抱歉, 你访问的页面不存在."
    >
      <template #extra>
        <a-button type="primary" @click="handleRedirct"> 回到首页 </a-button>
      </template>
    </a-result>
  </div>
</template>

<script>
export default {
  methods: {
    handleRedirct() {
      this.$router.replace('/')
    }
  }
};
</script>

<style scoped>
</style>
