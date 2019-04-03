const schedule = require("node-schedule");

//segundos minuto hora dia mes diaSemana(0 domingo)
const tarefa1 = schedule.scheduleJob("*/1 * * * * *", function() {
    console.log('Executando Tarefa 1!', new Date().getSeconds())
});

setTimeout(() => {
    tarefa1.cancel();
    console.log("Cancelando tarefa 1.");
}, 40000);

const regra = new schedule.RecurrenceRule();
regra.dayOfWeek = [new schedule.Range(1, 5)];
regra.hour = 15;
regra.second = 40;

const tarefa2 = schedule.scheduleJob(regra, () => {
    console.log('Executando Tarefa 2!', new Date().getSeconds())
});