document.addEventListener('DOMContentLoaded', () => {
    const workspace = document.getElementById('workspace');
    const addButton = document.getElementById('addButton');
    const saveButton = document.getElementById('saveButton');

    addButton.addEventListener('click', () => {
        const element = document.createElement('div');
        element.className = 'element';
        element.draggable = true;
        element.style.left = '0px';
        element.style.top = '0px';

        element.addEventListener('dragstart', (e) => {
            e.dataTransfer.setData('text/plain', null);
        });

        element.addEventListener('dragend', (e) => {
            const rect = workspace.getBoundingClientRect();
            element.style.left = `${e.pageX - rect.left}px`;  // Corrected template literal syntax
            element.style.top = `${e.pageY - rect.top}px`;    // Corrected template literal syntax
        });

        workspace.appendChild(element);
    });

    saveButton.addEventListener('click', () => {
        const elements = [];
        document.querySelectorAll('.element').forEach((el, index) => {
            const rect = el.getBoundingClientRect();
            const workspaceRect = workspace.getBoundingClientRect();
            elements.push({
                id: `element-${index}`,  // Corrected template literal syntax
                type: 'div',
                width: el.offsetWidth,
                height: el.offsetHeight,
                color: window.getComputedStyle(el).backgroundColor,
                font: window.getComputedStyle(el).fontFamily,
                fontSize: parseInt(window.getComputedStyle(el).fontSize),
                left: rect.left - workspaceRect.left,
                top: rect.top - workspaceRect.top
            });
        });

        fetch('saveLayout', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(elements)
        }).then(response => response.json())
          .then(data => {
              if (data.status === 'success') {
                  alert('Layout saved successfully!');
              }
          });
    });
});
