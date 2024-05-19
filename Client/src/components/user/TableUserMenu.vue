<template>
    <div class="choose-box">
        <button class="btn" role="button" @click="showComponent('coach')">Тренера</button>
        <button class="btn" role="button" @click="showComponent('hall')">Залы</button>
        <button class="btn" role="button" @click="showComponent('training')">Виды тренировок</button>
        <button class="btn" role="button" @click="showComponent('record')">Записи на тренировки</button>
    </div>
  </template>

<script>
export default {
  name: 'table-user',
  components: {
    },
  data() {
    return {
      
    }
  },
 computed: {
    },
 methods: {
      showComponent(componentName) {
        this.$router.push({ name: componentName});
      }
    },
 mounted(){
      
    }
}
</script>

<style scoped>

.choose-box {
    width: 100%;
    height: 50vh;
    display: flex;
    align-items: center;
    justify-content: space-around;
}

.btn {
  align-items: center;
  background-color: #fff;
  border: 2px solid #0bb931;
  border-radius: 50%;
  box-sizing: border-box;
  color: #000;
  cursor: pointer;
  display: inline-flex;
  fill: #000;
  font-family: Inter,sans-serif;
  font-size: 16px;
  font-weight: 600;
  height: 48px;
  justify-content: center;
  letter-spacing: -.8px;
  line-height: 24px;
  min-width: 140px;
  outline: 0;
  padding: 0 17px;
  text-align: center;
  text-decoration: none;
  transition: all .3s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.btn:focus {
  color: #0bb310;
}

.btn:hover {
  border-color: #12c18c;
  color: #12c18c;
  fill: #12c18c;
}

.btn:active {
  border-color: #12c18c;
  color: #12c18c;
  fill: #12c18c;
}

@media (min-width: 768px) {
  .btn {
    min-width: 170px;
  }
}
</style>