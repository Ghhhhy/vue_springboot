<template>
  <div>
    <h1>{{ title }}</h1>
    <div v-html="content"></div>
  </div>
</template>

<script>
import { getNewsDetail } from "@/api/news";
export default {
  data() {
    return {
      title: "",
      content: "",
    };
  },
  mounted() {
    getNewsDetail({
      id: this.$route.query.id,
    }).then((res) => {
      this.title = res.data.data[0]["title"];
      this.content = res.data.data[0]["content"];
    });
  },
};
</script>

<style scoped>
h1 {
  font-size: 2em;
  color: #1890ff;
  display: flex;
  justify-content: center;
  padding: 0 auto;
}
</style>
