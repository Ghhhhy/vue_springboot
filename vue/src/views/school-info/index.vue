<template>
  <div>
    <div class="container">
      <font class="school_name">{{ school.name }}</font>
      <div class="school_container">
        <div class="school_img">
          <a-avatar
            class="img"
            :size="120"
            slot="avatar"
            :src="school.imgurl"
          />
        </div>
        <div class="school_info">
          <a-descriptions>
            <a-descriptions-item label="高校类型" :span="3">
              <a-tag color="red"> {{ school.features.slice(0, 3) }} </a-tag>
              <a-tag color="blue"> {{ school.features.slice(3) }}</a-tag>
            </a-descriptions-item>
            <a-descriptions-item label="高校隶属" :span="3">
              {{ school.affilate }}
            </a-descriptions-item>
            <a-descriptions-item label="高校所在地" :span="3">
              {{ school.province }}
            </a-descriptions-item>
            <a-descriptions-item label="学校网址" :span="3">
              {{ school.website }}
            </a-descriptions-item>
          </a-descriptions>
        </div>
      </div>
    </div>
    <div class="content">
      <a-tabs default-active-key="1">
        <a-tab-pane key="1" tab="学校简介" style="white-space: pre-wrap">{{ school.content }}</a-tab-pane>
      </a-tabs>
    </div>
  </div>
</template>

<script>
import { findSchools } from "@/api/school";
export default {
  data() {
    return {
      school: {},
    };
  },
  methods: {
    getSchoolsInfo() {
      findSchools({
        id: this.$route.query.id,
      }).then((res) => {
        const { data } = res.data;
        this.school = data[0];
      });
    },
  },
  created() {
    this.getSchoolsInfo();
  },
};
</script>

<style scoped>
.school_container {
  width: 80vw;
  min-height: 200px;
  /* background-color: grey; */
  margin: 10px 0 10px;
  position: relative;
  border: 1px solid #ebe9e9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
}

.container .school_name {
  font-size: 25px;
  margin-left: 10px;
  color: #1890ff;
}

.school_container .school_img {
  position: absolute;
  height: 100%;
  width: 200px;
}

.school_container .school_img .img {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateY(-50%) translateX(-50%);
}

.school_container .school_info {
  width: 650px;
  height: 100%;
  position: absolute;
  /* background-color: rgb(224, 222, 222); */
  left: 200px;
  padding: 25px;
  display: flex;
}

.content {
  width: 80vw;
  border: 1px solid #ebe9e9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
  padding: 0 20px;
}
</style>
