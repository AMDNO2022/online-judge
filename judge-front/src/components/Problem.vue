
<template>
  <el-row>
    <p style="font-size: x-large">{{problem.name}}</p>
    <el-icon v-if="problem.status==1001" color="#39cc50" :size="16"><SuccessFilled/></el-icon>
    <el-icon v-else-if="problem.status==1002" color="#FF606d" :size="16"><CircleCloseFilled/></el-icon>
    <el-icon v-else-if="problem.status!=1000"  color="#eba54c" :size="16"><WarningFilled/></el-icon>

  </el-row><el-divider></el-divider>
  <el-row><p style="font-size: large">问题描述</p></el-row><br>
  <el-row><p>{{problem.description}}</p></el-row><br>
  <el-row><p style="font-size: large">样例输入</p></el-row><br>
  <el-row><p>{{problem.problemInput}}</p></el-row><br>
  <el-row><p style="font-size: large">样例输出</p></el-row><br>
  <el-row><p>{{problem.problemOutput}}</p></el-row><br>
  <el-row>
    <el-input
        v-model="textarea"
        :autosize="{ minRows: 8, maxRows: 18 }"
        type="textarea"
        placeholder="Please input your code."
    />
  </el-row>
  <el-row style="text-align: right">
    <el-col :span="24" style="margin-top: 10px">
      <el-button plain @click="submitCode">提交</el-button>
    </el-col>
  </el-row>
</template>

<script setup>

import {ref} from "vue";

const props = defineProps({ problemId : Number , status: Number});
const pid = props.problemId;
const status = props.status;
const problem = {
  id: 1231231312,
  name: '两数之和',
  status: 1001,
  description: '写一个函数，输入 a, b， 输出a+b\n',
  problemInput: '1 2\n',
  problemOutput: '3\n',
}

const textarea = ref('');

const submitCode = () => {
  console.log(textarea);
}

</script>

<style scoped>

</style>
