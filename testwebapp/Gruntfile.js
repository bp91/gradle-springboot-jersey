module.exports = function (grunt) {

	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),
		concat: {
			options: {
				separator: '\n\n'
			},
			dist: {
				src: [
					'src/main/webapp/js/app/*.js',
					'src/main/webapp/js/app/angularjs/controller/*.js'
				],
				dest: 'src/main/webapp/js/applicationScripts.js'
			}
		},
		uglify: {
			options: {
				banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n'
			},
			dist: {
				files: {
					'src/main/webapp/js/applicationScripts.min.js': [ 'src/main/webapp/js/applicationScripts.js' ]
				}
			}
		},
		less: {
			all: {
				options: {
					compress: true,
					yuicompress: true,
					optimization: 2
				},
				files: {
					'src/main/webapp/css/theme.css': 'src/main/webapp/css/less/theme.less'
				}
			}
		},
		copy: {
			html_resources: {
				files: [
					{
						expand: true,
						cwd: 'src/main/webapp/html/',
						src: ['**'],
						dest: 'src/main/resources/templates/'
					}
				]
			},
			html_static: {
				files: [
					{
						expand: true,
						cwd: 'src/main/webapp/html/',
						src: ['**'],
						dest: 'src/main/resources/static/templates/'
					}
				]
			},
			css: {
				files: [
					{
						expand: true,
						cwd: 'src/main/webapp/css/',
						src: ['**'],
						dest: 'src/main/resources/static/css/'
					}
				]
			},
			js: {
				files: [
					{
						expand: true,
						cwd: 'src/main/webapp/js/',
						src: ['**'],
						dest: 'src/main/resources/static/js/'
					}
				]
			}
		},
		watch: {
			less: {
				files: [
					'src/main/webapp/css/less/*.less'
				],
				tasks: [ 'less:all' ],
				options: {
					nospawn: true
				}
			},
			js: {
				files: ['src/main/webapp/js/**/*.js'],
				tasks: ['concat', 'uglify']
			},
			html: {
				files: ['src/main/webapp/html/*.html'],
				tasks: ['copy:html_resources', 'copy:html_static']
			}
		}
	});

	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-watch');
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-less');
	grunt.loadNpmTasks('grunt-contrib-copy');

	grunt.registerTask('default', [ 'concat', 'uglify', 'less', 'copy' ]);
	grunt.registerTask('build', [ 'concat', 'uglify', 'less', 'copy' ]);
};