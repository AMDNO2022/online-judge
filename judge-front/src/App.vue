<script setup>
import Sidebar from "@/components/Sidebar.vue";
import ProblemList from "@/components/ProblemList.vue";
import RecordList from "@/components/RecordList.vue";
import About from "@/components/About.vue";
import Problem from "@/components/Problem.vue";
import Record from "@/components/Record.vue";
</script>

<template>
  <div class="homeWrap">
    <el-card>
      <template #header>
        <el-row style="height: 7vh">
          <el-col :span="23">
            <el-button link><h1><el-icon><Cherry/></el-icon>  Online Judge</h1></el-button>
          </el-col>
          <el-col :span="1" >
            <el-button link><el-icon><Tools /></el-icon></el-button>
          </el-col>
        </el-row>
      </template>

      <el-row style="height: 80vh">
        <el-col :span="6">
            <sidebar @sidebarSelect="changePage" style="height: 100%"></sidebar>
        </el-col>
        <el-col :span="18" style="text-align: center">
          <ProblemList @problemSelect="changePage" v-if="showMain == 1"></ProblemList>
          <RecordList @recordSelect="changePage" v-else-if="showMain == 2"></RecordList>
          <Login v-else-if="showMain == 3"></Login>
          <About v-else-if="showMain == 4"></About>
          <Problem :problemId="id" v-else-if="showMain == 5"></Problem>
          <Record :recordId="id" v-else-if="showMain == 6"></Record>
        </el-col>
      </el-row>
    </el-card>
  </div>


</template>

<script>
import {ref} from "vue";

const showMain = ref('1');
const id = ref(0);
const status = ref(0);
const changePage = (val) => {
  showMain.value = val.content;
  if(showMain.value == 5 || showMain.value == 6){
    id.value = val.problemId;
    id.value = val.status;
  }
}
</script>

<style>
.homeWrap {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

</style>
