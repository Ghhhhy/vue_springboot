<template>
  <a-layout>
    <a-layout-header>
      <top/>
    </a-layout-header>
    <a-layout-content style="padding: 0 50px">
      <middle />
    </a-layout-content>
    <a-layout-footer>
      <bottom />
    </a-layout-footer>
    <a-back-top />
  </a-layout>
</template>

<script>
import { Top, Middle, Bottom } from "./components";

export default {
  components: {
    Top,
    Middle,
    Bottom,
  },
};
</script>

<style scoped>
</style>
