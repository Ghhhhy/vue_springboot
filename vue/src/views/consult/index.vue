<template>
  <div>
    <JwChat
      :taleList="list"
      @enter="bindEnter"
      v-model="inputMsg"
      scrollType="scroll"
      class="chat-form"
    />
  </div>
</template>

<script>
export default {
  data() {
    return {
      list: [],
      inputMsg: "",
    };
  },
  methods: {
    bindEnter() {
      const msg = this.inputMsg;
      if (!msg) return;
      const msgOject = {
        text: { text: msg },
        mine: true,
        name: this.name,
      };
      this.list.push(msgOject);
    },
  },
};
</script>

<style scoped>
.chat-form {
  position: relative;
  width: 520px;
  max-width: 100%;
  margin: 50px auto;
  overflow: hidden;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
</style>
