// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadEmployees();
  $('#employees').DataTable();
});

function loadEmployees() {
  (async () => {
    const request = await fetch('/employees/2612', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    });
    const employees = await request.json();

    console.log(employees);
  })();
}
