<template>
  <div>
    <div class="calendar">
      <router-link to="/consult/index">
        <div class="consult">
          <img
            src="../../assets/定位导航.png"
            :style="{ width: '70px', height: '70px', 'margin-right': '35px' }"
          />
          一对一高考志愿咨询
        </div>
      </router-link>
      <div
        :style="{
          color: 'white',
          margin: ' 15px 15px 0',
          'font-size': '18px',
        }"
      >
        <p>考生关注</p>
      </div>
      <div class="calendar-item" v-for="(item, index) in calendar" :key="index">
        <a-tag
          color="blue"
          :style="{ 'border-radius': '15px', 'margin-bottom': '10px' }"
          >{{ item.month }}</a-tag
        >
        <a-row :style="{ color: 'white' }">
          <a-col :span="12" v-for="(item2, index) in item.date" :key="index">
            {{ item2 }}
          </a-col>
        </a-row>
      </div>
    </div>
    <a-carousel autoplay effect="fade" dot-position="bottom" arrows>
      <div
        slot="prevArrow"
        class="custom-slick-arrow leftArrow"
        :style="{ left: '15px', zIndex: 99 }"
      >
        <a-icon type="left-circle" />
      </div>
      <div slot="nextArrow" class="custom-slick-arrow" style="right: 320px">
        <a-icon type="right-circle" />
      </div>
      <div>
        <img
          src="../../assets/qjjh2.jpg"
          :style="{ width: '1337.2px', height: '460px' }"
        />
      </div>
      <div>
        <img
          src="../../assets/cqfl2.png"
          :style="{ width: '1337.2px', height: '460px' }"
        />
      </div>
    </a-carousel>
    <a-row>
      <a-col :span="24">
        <a-card class="card" title="高考资讯">
          <a-row :gutter="12">
            <a-col :span="12">
              <a-list item-layout="horizontal" :data-source="news.slice(0, 3)">
                <a-list-item slot="renderItem" slot-scope="item">
                  <a-list-item-meta>
                    <p slot="title" class="news_title" @click="newItemClick(item.id)">{{ item.title }}</p>
                  </a-list-item-meta>
                </a-list-item>
              </a-list>
            </a-col>
            <a-col :span="12">
              <a-list item-layout="horizontal" :data-source="news.slice(3, 6)">
                <a-list-item slot="renderItem" slot-scope="item">
                  <a-list-item-meta>
                    <p slot="title" class="news_title" @click="newItemClick(item.id)" >{{ item.title }}</p>
                  </a-list-item-meta>
                </a-list-item>
              </a-list>
            </a-col>
          </a-row>
        </a-card>
      </a-col>
    </a-row>
    <a-row>
      <a-col :span="6" class="school" @click="schoolItemClick(schools[0].id)">
        <p>{{ schools[0].name }}</p>
        <div class="tags">
          <a-tag>{{ schools[0].type + "类" }}</a-tag>
          <a-tag>{{ schools[0].affilate }}</a-tag>
        </div>
        <img :src="schools[0].imgurl" />
      </a-col>
      <a-col :span="18">
        <a-card class="card" title="热门院校">
          <router-link slot="extra" to="/school">更多</router-link>
          <a-card-grid
            v-for="(item, index) in schools.slice(1)"
            :key="index"
            style="width: 334.4px"
            @click="schoolItemClick(item.id)"
          >
            <div class="schoolBox">
              <img :src="item.imgurl" class="image" />
              <b class="title">{{ item.name }}</b>
              <a-tag class="tag" color="blue">{{ item.type + "类" }}</a-tag>
              <span class="info">查看院校></span>
            </div>
          </a-card-grid>
        </a-card>
      </a-col>
    </a-row>
    <a-row>
      <a-col :span="24">
        <a-card class="card" title="热门专业">
          <router-link slot="extra" to="/profession">更多</router-link>
          <a-card-grid
            v-for="(item, index) in professions"
            :key="index"
            style="width: 25%"
            @click="professionItemClick(item.code)"
          >
            <div class="schoolBox">
              <img :src="item.src" />
              <b class="title title2">{{ item.name }}</b>
              <span class="tag">专业代码:{{ item.code }}</span>
            </div>
          </a-card-grid>
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<script>
import { getNews } from "@/api/news";
import { getRecommendSchools } from "@/api/school";
import { getProfessionsByPage } from "@/api/profession";
import { mapGetters } from "vuex";

export default {
  created() {
    getNews({}).then((res) => {
      const { data } = res.data;
      this.news = data.records;
      console.log(data.records);
      // const { news } = data;
      // this.news = news;
    });
    this.getSchools();
    this.getProfessionInfo();
  },
  computed: {
    ...mapGetters(["province"]),
  },
  data() {
    return {
      carouselImg: [],
      news: [],
      schools: [
        {
          name: "",
        },
      ],
      professions: [],
      calendar: [
        {
          month: "1月",
          date: ["特殊类招生", "港澳台招生"],
        },
        {
          month: "2月",
          date: ["艺校校考", "高水平艺术团简章", "高水平运动队简章"],
        },
        {
          month: "3月",
          date: ["报送生资格名单公示", "各省招生规定", "高考体检", "高职单招"],
        },
        {
          month: "4月",
          date: [
            "招生简章",
            "招生工作办法",
            "高校专项计划",
            "高职单招",
            "强基计划",
          ],
        },
        {
          month: "5月",
          date: ["高校专项计划", "招生工作办法", "强基计划", "志愿填报政策"],
        },
        {
          month: "6月",
          date: [
            "高考进行",
            "高考查分",
            "分数线",
            "志愿填报",
            "综合评价校考",
            "强基计划校考",
            "高校专项计划校考",
          ],
        },
        {
          month: "7月",
          date: [
            "中外合作办学科普",
            "志愿填报",
            "高考录取",
            "征集志愿",
            "高招防骗",
          ],
        },
        {
          month: "8月",
          date: ["高职填志愿", "录取查询", "录取通知书查询", "新生资助政策"],
        },
        {
          month: "9月",
          date: ["新生入学", "空军招飞", "海军招飞", "民航招飞"],
        },
        {
          month: "10月",
          date: ["招飞体检", "特殊类型招生"],
        },
        {
          month: "11月",
          date: ["高考报名", "艺考报名", "民航招飞", "高中学考报名"],
        },
        {
          month: "12月",
          date: ["高考报名", "艺考统考", "高中学考安排"],
        },
      ],
    };
  },
  methods: {
    newItemClick(id) {
      this.$router.push({
        path: '/new-info/index',
        query: {
          id: id
        }
      })
      console.log(id);
    },
    schoolItemClick(id) {
      this.$router.push({
        path: "/school-info/index",
        query: {
          id: id,
        },
      });
    },
    professionItemClick(code) {
      this.$router.push({
        path: "/profession-info/index",
        query: {
          code: code,
        },
      });
    },
    getSchools() {
      getRecommendSchools(
        {
          current: 1,
          pagesize: 10,
        },
        {
          province: this.province,
        }
      ).then((res) => {
        const { data } = res.data;
        const { records } = data;
        this.schools = records;
      });
    },
    getProfessionInfo() {
      getProfessionsByPage(
        {
          current: 1,
          pagesize: 8,
        },
        {}
      ).then((res) => {
        const { data } = res.data;
        const { records } = data;
        this.professions = records;
      });
    },
  },
  watch: {
    province() {
      this.getSchools();
    },
  },
};
</script>

<style scoped>
.calendar {
  width: 300px;
  height: 460px;
  background-color: rgba(22, 22, 22, 0.436);
  position: absolute;
  right: 91px;
  z-index: 999;
  overflow: auto;
}

.consult {
  width: 250px;
  height: 80px;
  margin-top: 16px;
  margin-left: 25px;
  background-color: #fff;
  border-radius: 10px;
  display: flex;
  align-items: center;
}

.calendar::-webkit-scrollbar {
  border-width: 1px;
}

.calendar .calendar-item {
  width: 100%;
  padding: 20px;
}

.news_title {
  font-size: 15px;
  font-weight: bold;
}

.news_title:hover {
  cursor: pointer;
  color: #1890ff;
}

.school {
  height: 508px;
  margin-top: 20px;
  background-color: #1890ff;
  position: relative;
}

.school:hover {
  cursor: pointer;
}

.school p {
  font-size: 30px;
  width: 100%;
  color: white;
  position: absolute;
  /* left: 50%; */
  top: 20%;
  text-align: center;
  /* transform: translateX(-50%); */
}

.school .tags {
  width: 150px;
  height: 50px;
  position: absolute;
  left: 50%;
  top: 35%;
  transform: translateX(-50%);
  display: flex;
  align-items: center;
  justify-content: center;
}

.school img {
  color: white;
  position: absolute;
  left: 50%;
  top: 55%;
  width: 180px;
  height: 180px;
  transform: translateX(-50%);
}

.schoolBox {
  position: relative;
  width: 100%;
  height: 100%;
}

.ant-card-grid {
  width: 200px;
  height: 150px;
  position: relative;
}

.image {
  width: 100px;
  height: 100px;
  border-radius: 50px;
}

.title {
  position: absolute;
  font-size: 15px;
  top: 10px;
  left: 110px;
}

.title2 {
  position: absolute;
  font-size: 15px;
  left: 50%;
  transform: translateX(-50%);
}

.schoolBox:hover .title,
.info {
  color: #1890ff;
  cursor: pointer;
}

.tag {
  position: absolute;
  top: 75px;
  left: 50%;
  transform: translateX(-50%);
}

.info {
  position: absolute;
  top: 75px;
  right: 10px;
}

.ant-carousel >>> .slick-slide {
  text-align: center;
  height: 460px;
  line-height: 460px;
  overflow: hidden;
}

.ant-carousel >>> .custom-slick-arrow {
  width: 25px;
  height: 25px;
  font-size: 25px;
  color: #fff;
  background-color: rgba(31, 45, 61, 0.11);
  opacity: 0.3;
}

.ant-carousel >>> .custom-slick-arrow:before {
  display: none;
}

.ant-carousel >>> .custom-slick-arrow:hover {
  opacity: 0.5;
}

.card {
  margin-top: 20px;
}
</style>
