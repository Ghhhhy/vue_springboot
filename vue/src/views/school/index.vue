<template>
  <div>
    <div class="search_container">
      <a-input
        placeholder="输入高校名称"
        style="width: 25%; margin: 10px 15px"
        v-model="search.name"
      />
      <a-button type="primary" @click="bindSearch"> 搜索 </a-button>
      <a-form-model
        :model="form"
        :label-col="labelCol"
        :wrapper-col="wrapperCol"
      >
        <a-form-item label="高校所在地" :style="{ margin: '5px' }">
          <a-radio-group
            v-model="form.province"
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
        <a-form-item label="高校类型" :style="{ margin: '3px' }">
          <a-radio-group
            v-model="form.type"
            button-style="solid"
            @change="bindRadioGroup"
          >
            <a-radio-button
              v-for="(item, index) in tags2"
              :key="index"
              :value="item"
            >
              {{ item }}
            </a-radio-button>
          </a-radio-group>
        </a-form-item>
        <a-form-item label="学历层次" :style="{ margin: '3px' }">
          <a-radio-group
            v-model="form.nature"
            button-style="solid"
            @change="bindRadioGroup"
          >
            <a-radio-button
              v-for="(item, index) in tags3"
              :key="index"
              :value="item"
            >
              {{ item }}
            </a-radio-button>
          </a-radio-group>
        </a-form-item>
      </a-form-model>
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
            <a-tag color="red"> {{ item.features.slice(0,3) }} </a-tag>
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
    <a-pagination
      :total="total"
      :pageSize.sync="pageSize"
      show-less-items
      :style="{ 'margin-top': '25px'}"
      v-model="current"
      :current="current"
      @change="onChange"
    ></a-pagination>
  </div>
</template>

<script>
import { findSchools, getSchoolsByPage, findSchoolsByDetails } from "@/api/school";
export default {
  data() {
    return {
      labelCol: { span: 2 },
      wrapperCol: { span: 22 },
      search: {
        name: ""
      },
      form: {
        province: "",
        type: "",
        nature: "",
      },
      tags: [
        "全部",
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
      tags2: [
        "全部",
        "综合",
        "工科",
        "农业",
        "师范",
        "民族",
        "林业",
        "医药",
        "语言",
        "财经",
        "体育",
        "艺术",
        "政法",
        "军事",
      ],
      tags3: ["全部", "本科", "高职专科", "独立学院", "教育部直属", "其它"],
      schools: [],
      current: 1,
      pageSize: 15,
      total: null,
    };
  },

  methods: {
    bindSearch() {
      findSchools(this.search).then(res => {
        const { data } = res.data
        console.log(data);
        this.schools = []
        this.current = 1,
        this.total = data.length
        this.schools = data
      })
    },
    getSchools() {
      getSchoolsByPage({
        current: this.current,
        pagesize: this.pageSize,
      }).then((res) => {
        const { data } = res.data;
        const { records } = data;
        this.total = data.total;
        this.schools = records;
      });
    },
    schoolContainerClick(id) {
      this.$router.push({
        path: "/school-info/index",
        query: {
          id: id,
        },
      });
    },
    bindRadioGroup() {
      const data = this.form;
      if (data.province === "全部") {
        data.province = "";
      } else if (data.type === "全部") {
        data.type = "";
      } else if (data.nature === "全部") {
        data.nature = "";
      }
      findSchoolsByDetails(
        {
          current: this.current,
          pagesize: this.pageSize,
        },
        data
      ).then((res) => {
        const { data } = res.data;
        const { records } = data;
        this.total = data.total;
        this.current = 1;
        this.schools = records;
         console.log("1");
      });
      console.log(data);
    },
    onChange() {
      findSchoolsByDetails(
        {
          current: this.current,
          pagesize: this.pageSize,
        },
        this.form
      ).then((res) => {
        const { data } = res.data;
        const { records } = data;
        this.schools = records;
      });
    },
  },
  created() {
    this.getSchools();
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
