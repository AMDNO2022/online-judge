<template>
  <el-table
      :data="tableData"
      :default-sort="{ prop: 'id', order: 'descending' }"
      style="width: 100%"
      stripe
  >
    <el-table-column prop="name" label="题目" >
      <template #default="scope" >
        <el-button link @click="problemClick(scope.row.id, scope.row.status)">{{ scope.row.name }}</el-button>
      </template>
    </el-table-column>
    <el-table-column label="状态" fixed="right" min-width="24%" align="center">
      <template #default="scope">
        <el-icon v-if="scope.row.status==1001" color="#39cc50" :size="16"><SuccessFilled/></el-icon>
        <el-icon v-else-if="scope.row.status==1002" color="#FF606d" :size="16"><CircleCloseFilled/></el-icon>
        <el-icon v-else-if="scope.row.status!=1000"  color="#eba54c" :size="16"><WarningFilled/></el-icon>
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
    name: '两数之和',
    status: 1001,
  },
  {
    id: 213213123123,
    name: '两数之和2',
    status: 1002,
  },
  {
    id: 1231231312,
    name: '斐波那契数列',
    status: 1000,
  },
  {
    id: 1231231312,
    name: 'LRU算法',
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
