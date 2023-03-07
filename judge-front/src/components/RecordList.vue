<template>
  <el-table
      :data="recordData"
      :default-sort="{ prop: 'dateTime', order: 'descending' }"
      style="width: 100%"
      stripe
  >
    <el-table-column prop="uname" min-width="30%" label="提交者" ></el-table-column>
    <el-table-column label="题目" >
      <template #default="scope" >
        <el-button link @click="problemClick(scope.row.qid, scope.row.status)">{{ scope.row.qname }}</el-button>
      </template>
    </el-table-column>
    <el-table-column label="状态" fixed="right" min-width="24%" align="center">
      <template #default="scope">
        <el-icon v-if="scope.row.status==1001" color="#39cc50" :size="16"><SuccessFilled/></el-icon>
        <el-icon v-else-if="scope.row.status==1002" color="#FF606d" :size="16"><CircleCloseFilled/></el-icon>
        <el-icon v-else-if="scope.row.status!=1000"  color="#eba54c" :size="16"><WarningFilled/></el-icon>
      </template>
    </el-table-column>
    <el-table-column  fixed="right" min-width="42%" label="提交时间"  >
      <template #default="scope">
        <p style="font-size: xx-small">{{scope.row.dateTime}}</p>
      </template>
    </el-table-column>
  </el-table>
</template>

<script lang="ts" setup>
import type { TableColumnCtx } from 'element-plus'
import {defineEmits} from "vue";

interface Record {
  uid: number
  uname: string
  qid: number
  qname: string
  status: number
  dateTime: string
}

const recordData: Record[] = [
  {
    uid: 123123123,
    uname: 'Admin',
    qid: 123123,
    qname: '两数之和',
    status: 1001,
    dateTime: '2023-03-01 00:00:00'
  }
]
const emit = defineEmits(["problemSelect"])

const problemClick = (id: number, sts: number) =>{
  let param = {
    content: 5,
    problemId: id,
    status: sts
  }
  //传递给父组件
  emit('problemSelect', param)
}

</script>

<style scoped>

</style>
