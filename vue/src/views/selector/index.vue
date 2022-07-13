<template>
  <div>
    <div class="search_container">
      <a-form
        :form="form"
        :label-col="{ span: 5 }"
        :wrapper-col="{ span: 12 }"
        style="width: 500px"
      >
        <a-form-item label="分数">
          <a-input-number
            v-model="form.score"
            style="width: 300px"
          ></a-input-number>
        </a-form-item>
        <a-form-item :wrapper-col="{ span: 14, offset: 5 }">
          <a-button type="primary" @click="handleSubmit"> 提交 </a-button>
          <a-button style="marginLeft: 10px" @click="handleClear"> 重置 </a-button>
        </a-form-item>
      </a-form>
    </div>
    <div class="school_container" v-for="(item, index) in schools" :key="index">
      <div class="school_img">
        <a-avatar class="img" :size="100" slot="avatar" :src="item.imgurl" />
        <h1 @click="schoolContainerClick(item.id)">{{ item.name }}</h1>
      </div>
      <div class="school_info">
        <a-descriptions>
          <a-descriptions-item label="高校所在地">
            {{ item.province }}
          </a-descriptions-item>
          <a-descriptions-item label="院校特色" :span="2">
            <a-tag color="red"> {{ item.features.slice(0, 3) }} </a-tag>
            <a-tag color="blue"> {{ item.features.slice(3) }}</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="高校类型">
            {{ item.type }}
          </a-descriptions-item>
          <a-descriptions-item label="高校隶属" :span="2">
            {{ item.affilate }}
          </a-descriptions-item>
          <a-descriptions-item label="高校性质">
            {{ item.nature }}
          </a-descriptions-item>
          <a-descriptions-item label="学校网址" :span="2">
            {{ item.website }}
          </a-descriptions-item>
        </a-descriptions>
      </div>
      <div class="school_button">
        <a-button
          type="primary"
          class="button"
          @click="schoolContainerClick(item.id)"
        >
          详细
        </a-button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { recommend } from "@/api/recommend";

export default {
  data() {
    return {
      form: {
        score: 0,
      },
      schools: [],
    };
  },
  methods: {
    handleSubmit() {
      recommend({
        score: this.form.score,
        province: this.province,
      }).then((res) => {
        if(res.data.data.records.length === 0) {
          this.schools = 0
          return
        }
        this.schools = res.data.data.records;
      });
    },
    handleClear() {
      this.form.score = 0
      this.schools = []
    },
    schoolContainerClick(id) {
      this.$router.push({
        path: "/school-info/index",
        query: {
          id: id,
        },
      });
    },
  },
  computed: {
    ...mapGetters(["province"]),
  },
};
</script>

<style scoped>
.search_container {
  width: 80vw;
  min-height: 180px;
  margin: 10px 0 10px;
  position: relative;
  border: 1px solid #ebe9e9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
  padding: 20px;
  display: flex;
  align-items: center;
}

.school_container {
  width: 80vw;
  height: 150px;
  /* background-color: grey; */
  margin: 10px 0 10px;
  position: relative;
  border: 1px solid #ebe9e9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
}

.school_container:hover {
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
}

.school_container .school_img {
  position: absolute;
  height: 100%;
  width: 150px;
  background-color: rgb(252, 252, 252);
}

.school_container .school_img .img {
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translateY(-50%) translateX(-50%);
}

.school_container .school_img h1 {
  position: absolute;
  top: 80%;
  left: 50%;
  font-size: 12px;
  transform: translateX(-50%);
}

.school_container .school_img h1:hover {
  cursor: pointer;
  text-decoration: underline;
  color: #1890ff;
}

.school_container .school_info {
  width: 650px;
  height: 100%;
  position: absolute;
  /* background-color: rgb(224, 222, 222); */
  left: 150px;
  display: flex;
  align-items: center;
  padding: 10px;
}

.school_container .school_button {
  width: 150px;
  height: 100%;
  position: absolute;
  right: 0;
  /* background-color: rgb(224, 222, 222); */
}

.school_container .school_button .button {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateY(-50%) translateX(-50%);
}
</style>
