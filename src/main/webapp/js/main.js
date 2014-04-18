require.config({
	paths: {
        jquery: 'jquery-2.1.0',
        ztree:  'jquery.ztree.core-3.5',
        bootstrap: 'bootstrap'
    },
    shim: {
    	'bootstrap': {
    		deps: ['jquery']
    	},

　　   	'ztree': {
			deps: ['jquery'],
			exports: 'ztree'
		}
　　}

});
 
require(['jquery', 'treeDialogSelect'], function($, treeDialogSelect) {
		//$('#treeDialogSelect').click(treeDialogSelect);

	//selectOrganization();
	
	});

