<template>
    <div class="table-box">
      <a class="add-button" href="/menu-admin">Вернуться</a>
      <div class="table-wrapper">
        <table class="fl-table">
          <thead>
            <tr>
              <th>Имя</th>
              <th>Отчество</th>
              <th>Фамилия</th>
              <th>Телефон</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="client in clients" :key="client.id" @click="openModal(client)">
              <td>{{ client.name }}</td>
              <td>{{ client.patronymic }}</td>
              <td>{{ client.surname }}</td>
              <td>{{ client.telephone }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </template>

  <script>
export default {
  name: 'clients',
  components: {
    },
  data() {
    return {
      clients: [],
      clientData: {
        name: "",
        patronymic: "",
        surname: "",
        telephone: "",
      },
      selectedClient: null,
      editedClient: {
        name: "",
        patronymic: "",
        surname: "",
        telephone: "",
        login: "",
        password: "",
        role_id: "",
      },

    }
  },
 computed: {
    },
 methods: {
      async getClients() {
        try {
          const response = await fetch('http://localhost:8080/clients/table');
          const data = await response.json();
          this.clients = data;
        } catch (error) {
          console.error('Ошибка при получении данных:', error);
        }
      },
        
        openModal(client) {
          this.selectedClient = client;
          this.editedClient = { ...client }; 
        },
        closeModal() {
          this.selectedClient = null;
        },
        
    },
 mounted(){
      this.getClients();
    }
}
</script>

<style scoped>
.table-box {
  padding-top: 10vh;
}


* {
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
}
body {
  font-family: Helvetica;
  -webkit-font-smoothing: antialiased;
  background: rgba(71, 147, 227, 1);
}
h2 {
  text-align: center;
  font-size: 18px;
  text-transform: uppercase;
  letter-spacing: 1px;
  color: white;
  padding: 30px 0;
}

.table-wrapper {
  margin: 10px 70px 70px;
  box-shadow: 0px 35px 50px rgba(0, 0, 0, 0.2);
}

.fl-table {
  border-radius: 5px;
  font-size: 12px;
  font-weight: normal;
  border: none;
  border-collapse: collapse;
  width: 100%;
  max-width: 100%;
  white-space: nowrap;
  background-color: white;
}

.fl-table td,
.fl-table th {
  text-align: center;
  padding: 8px;
}

.fl-table td {
  border-right: 1px solid #f8f8f8;
  font-size: 18px;
}

.fl-table thead th {
  color: #ffffff;
  background: #fd6e00;
}

.fl-table thead th:nth-child(odd) {
  color: #ffffff;
  background: #604832;
}

.fl-table tr {
  font-size: 28px;
}

.fl-table tr:nth-child(even) {
  background: #f8f8f8;
}


@media (max-width: 767px) {
  .fl-table {
    display: block;
    width: 100%;
  }
  .table-wrapper:before {
    content: "Scroll horizontally >";
    display: block;
    text-align: right;
    font-size: 11px;
    color: white;
    padding: 0 0 10px;
  }
  .fl-table thead,
  .fl-table tbody,
  .fl-table thead th {
    display: block;
  }
  .fl-table thead th:last-child {
    border-bottom: none;
  }
  .fl-table thead {
    float: left;
  }
  .fl-table tbody {
    width: auto;
    position: relative;
    overflow-x: auto;
  }
  .fl-table td,
  .fl-table th {
    padding: 20px 0.625em 0.625em 0.625em;
    height: 60px;
    vertical-align: middle;
    box-sizing: border-box;
    overflow-x: hidden;
    overflow-y: auto;
    width: 120px;
    font-size: 13px;
    text-overflow: ellipsis;
  }
  .fl-table thead th {
    text-align: left;
    border-bottom: 1px solid #f7f7f9;
  }
  .fl-table tbody tr {
    display: table-cell;
  }
  .fl-table tbody tr:nth-child(odd) {
    background: none;
  }
  .fl-table tr:nth-child(even) {
    background: transparent;
  }
  .fl-table tr td:nth-child(odd) {
    background: #f8f8f8;
    border-right: 1px solid #e6e4e4;
  }
  .fl-table tr td:nth-child(even) {
    border-right: 1px solid #e6e4e4;
  }
  .fl-table tbody td {
    display: block;
    text-align: center;
  }
}

.fl-table-editable {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

.fl-table-editable th,
.fl-table-editable td {
  border: 1px solid #e0e0e0;
  padding: 8px;
  text-align: left;
}

.fl-table-editable th {
  background-color: #f2f2f2;
}

.fl-table-editable tbody tr:hover {
  background-color: #f5f5f5;
}


.add-button {
  background-color: #4caf50;
  color: white;
  border: none;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 50%;
}

.add-button:hover {
  background-color: #45a049;
}

/* Стили для иконки крестика */
.delete-icon {
  cursor: pointer;
  color: red;
  font-weight: bold;
}

.delete-icon:hover {
  transform: scale(1.1);
}

.table-box-under .table-wrapper .fl-table tbody tr td {
  border: 1px solid black;
}


.button-40 {
  background-color: #111827;
  border: 1px solid transparent;
  border-radius: .75rem;
  box-sizing: border-box;
  color: #FFFFFF;
  cursor: pointer;
  flex: 0 0 auto;
  font-family: "Inter var",ui-sans-serif,system-ui,-apple-system,system-ui,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
  font-size: 1.125rem;
  font-weight: 600;
  line-height: 1.5rem;
  padding: .75rem 1.2rem;
  text-align: center;
  text-decoration: none #6B7280 solid;
  text-decoration-thickness: auto;
  transition-duration: .2s;
  transition-property: background-color,border-color,color,fill,stroke;
  transition-timing-function: cubic-bezier(.4, 0, 0.2, 1);
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: auto;
}

.button-40:hover {
  background-color: #374151;
}

.button-40:focus {
  box-shadow: none;
  outline: 2px solid transparent;
  outline-offset: 2px;
}

@media (min-width: 768px) {
  .button-40 {
    padding: .75rem 1.5rem;
  }
}



input {
  height: 40px;
  border-radius: 10px;
  text-align: center;
}

input:disabled {
  color: white;
}


label {
  color: white;
}



.modal {
  display: block;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
  background-color: #333;
  margin: 15% auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.modal-inner {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.modal-header {
  display: flex;
  justify-content: space-between;
  flex-direction: row;
}

.close-modal {
  color: #aaa;
  /* float: right; */
  font-size: 28px;
  font-weight: bold;
}

.close-modal:hover,
.close-modal:focus {
  color: #977e7e;
  text-decoration: none;
  cursor: pointer;
}


.modal-input {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: -webkit-fill-available;
  font-family: 'Segoe UI', sans-serif;
  margin: 1em 0 1em 0;
  max-width: 310px;
}


</style>