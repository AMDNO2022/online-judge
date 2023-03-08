<template>
  <el-menu
      active-text-color="#ff00b3"
      :default-active="activeIndex"
      @select="handleSelect"
  >
      <div class="top-sidebar">
          <el-menu-item index="1">题库</el-menu-item>
          <el-menu-item index="2">所有提交</el-menu-item>
      </div>
      <div class="down-sidebar">
          <el-menu-item index="4">关于</el-menu-item>
      </div>
  </el-menu>

</template>

<script lang="ts" setup>

import {ref, defineEmits} from 'vue';

const activeIndex = ref('1');

const emit = defineEmits(["sidebarSelect"])
const handleSelect = (key: string, keyPath: string[]) => {
  let param = {
    content: key
  }
  //传递给父组件
  emit('sidebarSelect', param)
}

</script>

<style scoped>

.top-sidebar{
  height: 72vh;
}
.down-sidebar{
  height: 10vh;
}
</style>
