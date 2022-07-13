<template>
  <div>
    <div class="search_container">
      <a-form-model
        :model="form"
        :label-col="labelCol"
        :wrapper-col="wrapperCol"
      >
        <a-form-item label="专业大类" :style="{ margin: '5px' }">
          <a-radio-group
            v-model="form.menlei"
            button-style="solid"
            @change="bindRadioGroup"
          >
            <a-radio-button
              v-for="(item, index) in tags"
              :key="index"
              :value="item"
              :style="{ marginTop: '5px' }"
            >
              {{ item }}
            </a-radio-button>
          </a-radio-group>
        </a-form-item>
        <a-form-item label="专业小类" :style="{ margin: '5px' }">
          <a-radio-group button-style="solid">
            <a-radio-button>
              全部
            </a-radio-button>
          </a-radio-group>
        </a-form-item>
      </a-form-model>
    </div>
    <div
      class="profession_container"
      v-for="(item, index) in professions"
      :key="index"
    >
      <div class="profession_img">
        <h1  @click="professionContainerClick(item.code)">{{ item.name }}</h1>
      </div>
      <div class="profession_info">
        <a-descriptions>
          <a-descriptions-item label="学科层次">
            {{ item.cenci }}
          </a-descriptions-item>
          <a-descriptions-item label="门类">
            {{ item.menlei }}
          </a-descriptions-item>
          <a-descriptions-item label="授予学位">
            {{ item.xuewei }}
          </a-descriptions-item>
          <a-descriptions-item label="学科">
            {{ item.xueke }}
          </a-descriptions-item>
          <a-descriptions-item label="专业代码">
            {{ item.code }}
          </a-descriptions-item>
        </a-descriptions>
      </div>
      <div class="profession_button">
        <a-button type="primary" class="button"  @click="professionContainerClick(item.code)"> 详细 </a-button>
      </div>
    </div>
    <a-pagination
      :total="total"
      :pageSize.sync="pageSize"
      show-less-items
      :style="{ 'margin-top': '25px' }"
      v-model="current"
      :current="current"
      @change="onChange"
    ></a-pagination>
  </div>
</template>

<script>
import { getProfessionsByPage } from "@/api/profession";
export default {
  data() {
    return {
      labelCol: { span: 2 },
      wrapperCol: { span: 22 },
      form: {
        menlei: "",
      },
      tags: ["全部", "法律", "公安", "文化教育", "公共事业", "旅游", "医药卫生", "财经", "轻纺食品", "环保、气象与安全", "电子信息", "制造", "水利", "土建", "材料与能源", "资源开发与测绘", "生化与药品", "交通运输", "农林牧渔", "艺术学", "艺术设计传媒", "经济学", "管理学", "理学", "法学", "文学", "教育学", "工学", "实验班", "哲学", "历史学", "医学", "农学", "军事学", "其他"],
      current: 1,
      pageSize: 15,
      professions: [],
      total: 0,
    };
  },
  methods: {
    professionContainerClick(code) {
      this.$router.push({
        path: "/profession-info/index",
        query: {
          code: code,
        },
      });
    },
    onChange() {
       if (this.form.menlei === "全部") {
        getProfessionsByPage(
          {
            current: this.current,
            pagesize: this.pageSize,
          },
          {}
        ).then((res) => {
          const { data } = res.data;
          this.professions = data.records;
          this.total = data.total;
        });
      } else {
        getProfessionsByPage(
          {
            current: this.current,
            pagesize: this.pageSize,
          },
          this.form
        ).then((res) => {
          const { data } = res.data;
          this.professions = data.records;
          this.total = data.total;
        });
      }
    },
    bindRadioGroup() {
      this.current = 1;
      this.total = 0;
      this.professions = [];
      if (this.form.menlei === "全部") {
        getProfessionsByPage(
          {
            current: this.current,
            pagesize: this.pageSize,
          },
          {}
        ).then((res) => {
          const { data } = res.data;
          this.professions = data.records;
          this.total = data.total;
        });
      } else {
        getProfessionsByPage(
          {
            current: 1,
            pagesize: this.pageSize,
          },
          this.form
        ).then((res) => {
          const { data } = res.data;
          this.professions = data.records;
          this.total = data.total;
        });
      }
    },
  },
  created() {
    getProfessionsByPage(
      {
        current: this.current,
        pagesize: this.pageSize,
      },
      {}
    ).then((res) => {
      const { data } = res.data;
      this.professions = data.records;
      this.total = data.total;
    });
  },
};
</script>

<style scoped>
.search_container {
  width: 80vw;
  min-height: 230px;
  margin: 10px 0 10px;
  position: relative;
  border: 1px solid #ebe9e9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
  padding: 20px;
}

.profession_container {
  width: 80vw;
  height: 150px;
  /* background-color: grey; */
  margin: 10px 0 10px;
  position: relative;
  border: 1px solid #ebe9e9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
}

.profession_container:hover {
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
}

.profession_container .profession_img {
  position: absolute;
  height: 100%;
  width: 150px;
  background-color: rgb(252, 252, 252);
  display: flex;
  align-items: center;
  justify-content: center;
}

.profession_container .profession_img h1:hover {
  cursor: pointer;
  text-decoration: underline;
  color: #1890ff;
}

.profession_container .profession_info {
  width: 650px;
  height: 100%;
  position: absolute;
  /* background-color: rgb(224, 222, 222); */
  left: 150px;
  display: flex;
  align-items: center;
  padding: 10px;
}

.profession_container .profession_button {
  width: 150px;
  height: 100%;
  position: absolute;
  right: 0;
  /* background-color: rgb(224, 222, 222); */
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
