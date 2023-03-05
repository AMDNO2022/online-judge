<template>
  <el-table
      :data="tableData"
      :default-sort="{ prop: 'date', order: 'descending' }"
      style="width: 100%"
      stripe
  >
    <el-table-column prop="name" label="题目" >
      <template #default="scope" >
        <el-button link @click="problemClick(scope.row.id, scope.row.status)">{{ scope.row.name }}</el-button>
      </template>
    </el-table-column>
    <el-table-column label="状态" fixed="right" min-width="15%" align="center">
      <template #default="scope">
        <el-icon v-if="scope.row.status==1001" color="#6B8E23" :size="16"><SuccessFilled/></el-icon>
        <el-icon v-else-if="scope.row.status==1002" color="#FF4500" :size="16"><CircleCloseFilled/></el-icon>
        <el-icon v-else-if="scope.row.status!=1000"  color="#FFA500" :size="16"><WarningFilled/></el-icon>
      </template>
    </el-table-column>
  </el-table>
</template>

<script lang="ts" setup>
import type { TableColumnCtx } from 'element-plus'
import {defineEmits} from "vue";

interface Question {
  id: number
  name: string
  status: number
}

const tableData: Question[] = [
  {
    id: 123123,
    name: '测试1',
    status: 1001,
  },
  {
    id: 213213123123,
    name: '测试2',
    status: 1002,
  },
  {
    id: 1231231312,
    name: '测试3',
    status: 1000,
  },
  {
    id: 1231231312,
    name: '测试4',
    status: 1003,
  },
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
