<template>
  <div class="container">
    <font class="profession_name">{{ profession.name }}</font>
    <div class="profession_container">
      <a-descriptions>
        <a-descriptions-item label="学科层次">
          {{ profession.cenci }}
        </a-descriptions-item>
        <a-descriptions-item label="门类">
          {{ profession.menlei }}
        </a-descriptions-item>
        <a-descriptions-item label="授予学位">
          {{ profession.xuewei }}
        </a-descriptions-item>
        <a-descriptions-item label="学科">
          {{ profession.xueke }}
        </a-descriptions-item>
        <a-descriptions-item label="专业代码">
          {{ profession.code }}
        </a-descriptions-item>
      </a-descriptions>
    </div>
    <div class="content">
      <a-tabs default-active-key="1">
        <a-tab-pane key="1" tab="专业简介" style="padding: 20px">
          <h1>
            {{
              profession.jxsj.slice(
                profession.jxsj.indexOf("\t", 1),
                profession.jxsj.indexOf("\r", 2)
              )
            }}
          </h1>
          <p>{{ profession.jxsj.slice(profession.jxsj.indexOf("\n", 2)) }}</p>

          <h1>
            {{
              profession.pymb.slice(
                profession.pymb.indexOf("\t", 1),
                profession.pymb.indexOf("\r", 2)
              )
            }}
          </h1>
          <p>{{ profession.pymb.slice(profession.pymb.indexOf("\n", 2)) }}</p>

          <h1>
            {{
              profession.pyyq.slice(
                profession.pyyq.indexOf("\t", 1),
                profession.pyyq.indexOf("\r", 2)
              )
            }}
          </h1>
          <p>{{ profession.pyyq.slice(profession.pyyq.indexOf("\n", 2)) }}</p>

          <h1>
            {{
              profession.jyfx.slice(
                profession.jyfx.indexOf("\t", 1),
                profession.jyfx.indexOf("\r", 2)
              )
            }}
          </h1>
          <p>{{ profession.jyfx.slice(profession.jyfx.indexOf("\n", 2)) }}</p>
        </a-tab-pane>
      </a-tabs>
    </div>
  </div>
</template>

<script>
import { getProfessionInfo } from "@/api/profession";
export default {
  data() {
    return {
      profession: {},
    };
  },
  created() {
    getProfessionInfo({
      code: this.$route.query.code,
    }).then((res) => {
      const { data } = res.data;
      this.profession = data[0];
    });
  },
};
</script>

<style scoped>
.container .profession_name {
  font-size: 25px;
  margin-left: 10px;
  color: #1890ff;
}

.profession_container {
  width: 80vw;
  min-height: 120px;
  /* background-color: grey; */
  margin: 10px 0 10px;
  padding: 25px;
  position: relative;
  border: 1px solid #ebe9e9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
}

.content {
  width: 80vw;
  border: 1px solid #ebe9e9;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
  padding: 0 20px;
}
</style>
