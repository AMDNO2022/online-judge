<template>
  <br />
  <div style=" border: 1px solid  var(--el-border-color); padding: 20px;border-radius: 8px;boxShadow: var(--el-box-shadow-light);">
    <el-avatar
        src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
    />
    <h4>Admin</h4>
      <el-divider></el-divider>
      <p>排名: 1/3</p>
      <p>已解决: 1/4</p>
    <el-divider></el-divider>
    <br />
    <el-progress type="circle" :percentage="25" />
    <br />
    <br />
  </div>

</template>

<script>
export default {
  name: "UserInfo"
}
</script>

<style scoped>

</style>
