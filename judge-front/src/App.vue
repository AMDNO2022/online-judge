<script setup>
import Sidebar from "@/components/Sidebar.vue";
import ProblemList from "@/components/ProblemList.vue";
import RecordList from "@/components/RecordList.vue";
import About from "@/components/About.vue";
import Problem from "@/components/Problem.vue";
import LoginBox from "@/components/LoginBox.vue";
import Record from "@/components/Record.vue";
import UserInfo from "@/components/UserInfo.vue";
</script>

<template>
    <el-card>
      <template #header>
        <el-row style="height: 7vh">
          <el-col :span="23">
            <el-button link @click="toMain"><h1><el-icon><Cherry/></el-icon>  Online Judge</h1></el-button>
          </el-col>
          <el-col :span="1" >
            <el-button link><el-icon><Tools /></el-icon></el-button>
          </el-col>
        </el-row>
      </template>

      <el-row>
        <el-col :span="4" style="height: 80vh">
            <sidebar @sidebarSelect="changePage" style="height: 100%"></sidebar>
        </el-col>
        <el-col :span="1">
        </el-col>

        <el-col :span="13" style="text-align: center; border: 1px solid  var(--el-border-color); padding: 20px;border-radius: 8px;boxShadow: var(--el-box-shadow-light);">
          <el-scrollbar height="75vh">
          <ProblemList @problemSelect="changePage" v-if="showMain == 1"></ProblemList>
          <RecordList @problemSelect="changePage" v-else-if="showMain == 2"></RecordList>
          <LoginBox v-else-if="showMain == 3"></LoginBox>
          <About v-else-if="showMain == 4"></About>
          <Problem :problemId="id" :status="questionStatus" v-else-if="showMain == 5"></Problem>
          <Record :problemId="id" v-else-if="showMain == 5"></Record>
          </el-scrollbar>
        </el-col>
        <el-col :span="1">
        </el-col>
        <el-col :span="4" style="text-align: center">
          <UserInfo></UserInfo>
        </el-col>
      </el-row>
    </el-card>


</template>

<script>
import {ref} from "vue";

const showMain = ref('1');
const id = ref(0);
const questionStatus = ref(0);
const changePage = (val) => {
  showMain.value = val.content;
  if(showMain.value == 5 || showMain.value == 6){
    id.value = val.problemId;
    questionStatus.value = val.status;
  }
}
const toMain = () => {
  showMain.value = 1;
}
</script>

<style>
.el-card{
  position : absolute;
  height: 100%;
  width : 100%;
}

</style>
