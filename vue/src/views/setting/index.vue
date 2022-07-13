<template>
  <div>
    <a-tabs default-active-key="1" tab-position="left">
      <a-tab-pane key="1" tab="基本设置">
        <profile />
      </a-tab-pane>
      <a-tab-pane key="2" tab="消息">
        <info />
      </a-tab-pane>
    </a-tabs>
  </div>
</template>
<script>
import { Profile, Info } from "./components";

export default {
  data() {
    return {};
  },
  methods: {},
  components: {
    Profile,
    Info,
  },
};
</script>

<style>
</style>