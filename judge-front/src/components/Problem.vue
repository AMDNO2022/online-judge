<template>
  <p>hello</p>
</template>

<script setup>
import {defineProps, toRefs} from 'vue';

const props = defineProps({ problemId : Number , status: Number});
const pid = props.problemId;
const problem = {
  id: 1231231312,
  name: '测试1',
  status: 1003,
  description: '测试test1描述',
  problemInput: '测试test1样例输入',
  problemOutput: '测试test1样例输出',
}
</script>

<style scoped>

</style>
2
